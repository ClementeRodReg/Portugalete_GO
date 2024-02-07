package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Grupo {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="idGrupo")
    private int idGrupo;
    @NonNull
    @ColumnInfo(name="Nombre")
    private String nombre;
    public Grupo(int idGrupo, String nombre){
        this.idGrupo = idGrupo;
        this.nombre = nombre;
    }
    public Grupo(){
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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
        return "Grupo " +idGrupo;
    }
}

