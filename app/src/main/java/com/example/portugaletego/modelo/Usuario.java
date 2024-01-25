package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Grupo " +id;
    }

    public Usuario(){

    }

    public Usuario(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;
    @NonNull
    @ColumnInfo(name="Nombre")
    private String nombre;


}

