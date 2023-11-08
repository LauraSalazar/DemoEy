package com.demoEy.controller;

import com.demoEy.model.UsuarioBody;
import com.demoEy.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PutMapping()
    public ResponseEntity<Object> addUsuario(@RequestBody UsuarioBody usuarioBody) {
        return usuarioService.add(usuarioBody);
    }

}
