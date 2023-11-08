package com.demoEy.utils;

public class MensajeError {

    private String mensaje;

    public MensajeError(String mensajeValue) {
        this.mensaje = mensajeValue;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
