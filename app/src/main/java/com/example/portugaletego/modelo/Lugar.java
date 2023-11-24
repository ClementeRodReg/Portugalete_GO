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
    @ColumnInfo(name="Coordenada")
    private Coordenada coordenada;

}
