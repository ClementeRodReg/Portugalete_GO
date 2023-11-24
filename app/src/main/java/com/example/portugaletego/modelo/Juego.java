package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Juego extends Contenido{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;
    @NonNull
    @ColumnInfo(name="Descripcion")
    private String descripcion;

}
