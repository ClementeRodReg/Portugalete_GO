package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Lugar {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="nombre")
    private String nombreLugar;

    @NonNull
    @ColumnInfo(name="textoLugar")
    public String texto;

    @NonNull
    @ColumnInfo(name="lat")
    public String lat;

    @NonNull
    @ColumnInfo(name="lon")
    public String lon;

    public Lugar(String nombreLugar, String texto, String lat, String lon){
        this.nombreLugar = nombreLugar;
        this.texto = texto;
        this.lat = lat;
        this.lon = lon;
    }

    @NonNull
    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(@NonNull String nombreL) {
        this.nombreLugar = nombreL;
    }

    @NonNull
    public String getTexto() {
        return texto;
    }

    public void setTexto(@NonNull String texto) {
        this.texto = texto;
    }

    @NonNull
    public String getLat() {
        return lat;
    }

    public void setLat(@NonNull String lat) {
        this.lat = lat;
    }




}
