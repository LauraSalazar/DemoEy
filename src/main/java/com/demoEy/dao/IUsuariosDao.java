package com.demoEy.dao;

import com.demoEy.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IUsuariosDao extends CrudRepository<Usuario, UUID> {

    public Usuario findByEmail(String email);
}
