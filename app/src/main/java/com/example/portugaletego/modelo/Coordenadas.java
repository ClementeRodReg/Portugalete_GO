package com.example.portugaletego.modelo;

public class Coordenadas {
    private String lugar;
    private String coordX;
    private String coordY;
    public Coordenadas(String lugar, String coordX, String coordY) {
        this.lugar = lugar;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

}

