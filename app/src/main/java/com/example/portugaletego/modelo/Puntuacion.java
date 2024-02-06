package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Puntuacion {

    @NonNull
    public String getPuntuacion_id() {
        return puntuacion_id;
    }

    public void setPuntuacion_id(@NonNull String puntuacion_id) {
        this.puntuacion_id = puntuacion_id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @PrimaryKey
    @NonNull //Se compone del id de grupo + la fecha de hoy
    @ColumnInfo(name="puntuacion_id")
    private String puntuacion_id;

    @NonNull //solo se almacenan los puntos de los juegos 2-3-4
    @ColumnInfo(name="puntos")
    private int puntos;




}
