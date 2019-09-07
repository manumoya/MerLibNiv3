package com.merlib.models;


public class Respuesta {

    private boolean mensaje;

    public Respuesta(){
    }

    public Respuesta(boolean mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isMensaje() {
        return mensaje;
    }

    public void setMensaje(boolean mensaje) {
        this.mensaje = mensaje;
    }
}
