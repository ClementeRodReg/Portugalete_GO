package com.example.portugaletego.modelo;

public class Usuario {
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

    private int id;
    private String nombre;


    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
