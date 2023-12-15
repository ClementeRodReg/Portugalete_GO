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
    @ColumnInfo(name="Lugar")
    private String nombre;

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
/*
    @NonNull
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(@NonNull Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @NonNull
    @ColumnInfo(name="Coordenada")
    private Coordenada coordenada;
*/
}
