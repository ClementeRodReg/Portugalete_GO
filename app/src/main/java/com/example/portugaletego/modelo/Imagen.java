package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(foreignKeys = {@ForeignKey( entity = Enunciados.class,
        parentColumns = "id_enunciado",
        childColumns = "id_enunciado",
        onDelete = ForeignKey.CASCADE)})
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

    @NonNull
    @ColumnInfo(name="id_enunciado")
    private String id_enunciado;

    public Imagen(int id, String Ruta, String id_enunciado){
        this.id = id;
        this.Ruta = Ruta;
        this.id_enunciado = id_enunciado;
    }

}
