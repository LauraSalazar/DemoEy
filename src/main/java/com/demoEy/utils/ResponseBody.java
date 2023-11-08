package com.demoEy.utils;

import java.util.UUID;

public class ResponseBody {

    private UUID usuarioId;

    private String created;

    private String modified;

    private String last_Login;

    private String token;

    private Boolean isActive;

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_Login() {
        return last_Login;
    }

    public void setLast_Login(String last_Login) {
        this.last_Login = last_Login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
