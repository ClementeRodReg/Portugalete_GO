package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Lugar {

    @NonNull
    @ColumnInfo(name="nombre")
    private String nombreLugar;

    @NonNull
    @ColumnInfo(name="textoLugar")
    public String texto;

    @NonNull
    @ColumnInfo(name="lat")
    public double lat;

    @NonNull
    @ColumnInfo(name="lon")
    public double lon;


    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id_lugar")
    public int id_lugar;

    public Lugar(@NonNull String nombreLugar, @NonNull String texto, @NonNull double lat, @NonNull double lon, @NonNull int id_lugar) {
        this.nombreLugar = nombreLugar;
        this.texto = texto;
        this.lat = lat;
        this.lon = lon;
        this.id_lugar = id_lugar;
    }

    @NonNull
    public double getLon() {
        return lon;
    }

    public void setLon(@NonNull double lon) {
        this.lon = lon;
    }

    @NonNull
    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(@NonNull int id_lugar) {
        this.id_lugar = id_lugar;
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
    public double getLat() {
        return lat;
    }

    public void setLat(@NonNull double lat) {
        this.lat = lat;
    }




}
