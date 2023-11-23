package com.example.portugaletego.modelo;

public class Respuesta {
    private int id;
    private String texto;

    public boolean isIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    private boolean iscorrect;

    public Respuesta(int id, String texto, boolean iscorrect) {
        this.id = id;
        this.texto = texto;
        this.iscorrect = iscorrect;
    }
}
