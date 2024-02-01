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
    @ColumnInfo(name="nombreL")
    private String nombreL;

    @NonNull
    @ColumnInfo(name="textoLugar")
    public String texto;

    @NonNull
    @ColumnInfo(name="lat")
    public String lat;

    @NonNull
    @ColumnInfo(name="lon")
    public String lon;

    @NonNull
    public String getNombreLugar() {
        return nombreL;
    }

    public void setNombreLugar(@NonNull String nombreL) {
        this.nombreL = nombreL;
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
