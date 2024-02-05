package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity
public class Imagen{

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @NonNull
    public String getRuta() {
        return Ruta;
    }
    public void setRuta(@NonNull String Ruta) {
        this.Ruta = Ruta;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;

    @NonNull
    @ColumnInfo(name="Ruta")
    private String Ruta;

}
