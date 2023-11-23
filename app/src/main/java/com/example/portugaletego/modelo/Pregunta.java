package com.example.portugaletego.modelo;

import java.util.List;

public class Pregunta {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    private List<Respuesta> respuestas;

    public Pregunta(int id, String nombre, List<Respuesta> respuestas) {
        this.id = id;
        this.nombre = nombre;
        this.respuestas = respuestas;
    }
}
