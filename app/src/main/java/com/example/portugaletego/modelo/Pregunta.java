package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Pregunta {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;

    @NonNull
    @ColumnInfo(name="Nombre")
    private String nombre;

    /*
    @NonNull
    @ColumnInfo(name="Respuestas")
    private List<Respuesta> respuestas;

    @NonNull
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(@NonNull List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    */

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


}
