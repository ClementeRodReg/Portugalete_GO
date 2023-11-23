package com.example.portugaletego.modelo;

public class Lugar {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getCoordenadas() {
        return coordenada;
    }

    public void setCoordenadas(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    private String nombre;
    private Coordenada coordenada;


    public Lugar(String nombre, Coordenada coordenada) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }
}
