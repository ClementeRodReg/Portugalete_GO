package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Coordenada {
    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(@NonNull String coordX) {
        this.coordX = coordX;
    }

    @NonNull
    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(@NonNull String coordY) {
        this.coordY = coordY;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private String id;
    @NonNull
    @ColumnInfo(name="lat")
    private String coordX;
    @NonNull
    @ColumnInfo(name="lon")
    private String coordY;



}

