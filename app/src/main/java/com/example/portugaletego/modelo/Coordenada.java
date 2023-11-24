package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Coordenada {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private String id;
    @NonNull
    @ColumnInfo(name="CoordX")
    private String coordX;
    @NonNull
    @ColumnInfo(name="CoordY")
    private String coordY;



}

