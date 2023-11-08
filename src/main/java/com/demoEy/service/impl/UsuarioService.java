package com.demoEy.service.impl;

import com.demoEy.dao.IPhoneDao;
import com.demoEy.dao.IUsuariosDao;
import com.demoEy.entity.Phone;
import com.demoEy.entity.Usuario;
import com.demoEy.model.PhoneBody;
import com.demoEy.model.UsuarioBody;
import com.demoEy.service.IUsuarioService;
import com.demoEy.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioService implements IUsuarioService {

    private final String EMAIL_EXISTS = "El correo ya esta registrado";

    private final String INVALID_EMAIL = "El correo de tener el formato aaaaaaa@dominio.pais";

    private final String INVALID_PASSWORD = "La clave debe contener una mayuscula, letras minusculas y dos numeros en ese orden";

    private final String INTERNAL_ERROR = "Se produjo un error interno desconocido";

    @Autowired
    private IUsuariosDao usuariosDao;

    @Autowired
    private IPhoneDao phoneDao;
    @Autowired
    JWTGenerator jwtGenerator;

    public ResponseEntity<Object> add(UsuarioBody usuarioBody) {

        ResponseBody responseBody = new ResponseBody();

        Usuario usuario = null;

        try {
            if (usuarioBody.getEmail() != null && this.invalidEmail(usuarioBody.getEmail())) {
                throw new EmailInvalidException();
            }
            if (usuarioBody.getEmail() != null && (usuariosDao.findByEmail(usuarioBody.getEmail()) != null)) {
                throw new EmailExistsException();
            }
            if (usuarioBody.getPassword() != null && this.invalidPassword(usuarioBody.getPassword())) {
                throw new PasswordInvalidException();
            }

            usuario = new Usuario();
            usuario.setPhones(new ArrayList<Phone>());
            usuario.setUsuario_id(UUID.randomUUID());
            responseBody.setUsuarioId(usuario.getUsuario_id());
            usuario.setPassword(usuarioBody.getPassword());
            usuario.setActive(true);
            responseBody.setActive(true);
            usuario.setCreated(LocalDate.now());
            responseBody.setCreated(LocalDate.now().toString());
            usuario.setModified(LocalDate.now());
            responseBody.setModified(LocalDate.now().toString());
            usuario.setLast_login(LocalDate.now());
            responseBody.setLast_Login(LocalDate.now().toString());
            usuario.setEmail(usuarioBody.getEmail());
            usuario.setNombre(usuarioBody.getName());
            usuario.setToken(jwtGenerator.generataToken(usuarioBody.getName(), usuarioBody.getPassword()));
            responseBody.setToken(usuario.getToken());
            usuariosDao.save(usuario);

            for (PhoneBody phone : usuarioBody.getPhones()) {
                Phone p = new Phone();
                p.setUsuario(usuario);
                p.setNumero(phone.getNumber());
                p.setCityCode(phone.getCitycode());
                p.setCountrycode(phone.getContrycode());
                usuario.addPhone(p);
                phoneDao.save(p);

            }


        } catch (EmailInvalidException emailInvalidException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeError(this.INVALID_EMAIL));
        } catch (EmailExistsException emailExistsException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MensajeError(this.EMAIL_EXISTS));
        } catch (PasswordInvalidException passwordInvalidException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeError(this.INVALID_PASSWORD));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MensajeError(this.INTERNAL_ERROR));
        }

        return ResponseEntity.ok(responseBody);

    }

    private Boolean invalidEmail(String email) {
        String expresionRegular = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern patrón = Pattern.compile(expresionRegular);
        Matcher matcher = patrón.matcher(email);
        return !matcher.matches();
    }

    private Boolean invalidPassword(String password) {
        String expresionRegular = "^(?=.*[A-Z])(?=.*[a-z])(.*\\d.*){2,}$";
        Pattern patrón = Pattern.compile(expresionRegular);
        Matcher matcher = patrón.matcher(password);
        return !matcher.matches();
    }
}
