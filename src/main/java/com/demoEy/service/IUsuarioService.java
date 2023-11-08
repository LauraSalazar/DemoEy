package com.demoEy.service;

import com.demoEy.model.UsuarioBody;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {
    public ResponseEntity<Object> add(UsuarioBody usuarioBody);
}
