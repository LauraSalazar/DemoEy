package com.demoEy.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="USUARIOS")
public class Usuario {

    @Id
    private UUID usuario_id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="token")
    private String token;

    @Column(name="created")
    private LocalDate created;

    @Column(name="modified")
    private LocalDate modified;

    @Column(name="last_login")
    private LocalDate last_login;

    @Column(name="isActive")
    private Boolean isActive;

    @OneToMany(mappedBy = "usuario")
    private List<Phone> phones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public UUID getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(UUID usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public LocalDate getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDate last_login) {
        this.last_login = last_login;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }
}
