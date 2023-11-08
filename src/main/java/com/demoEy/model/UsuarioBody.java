package com.demoEy.model;

import java.util.List;
import java.util.UUID;

public class UsuarioBody {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneBody> phones;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneBody> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneBody> phones) {
        this.phones = phones;
    }
}
