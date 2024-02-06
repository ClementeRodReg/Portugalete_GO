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



    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id_imagen")
    private int id_imagen;

    @NonNull
    @ColumnInfo(name="Ruta")
    private String Ruta;

    public Imagen() {
        
    }

    @NonNull
    public String getId_enunciado() {
        return id_enunciado;
    }

    public void setId_enunciado(@NonNull String id_enunciado) {
        this.id_enunciado = id_enunciado;
    }

    @NonNull
    @ColumnInfo(name="id_enunciado")
    private String id_enunciado;

    public Imagen(int id_imagen, @NonNull String ruta, @NonNull String id_enunciado) {
        this.id_imagen = id_imagen;
        Ruta = ruta;
        this.id_enunciado = id_enunciado;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    @NonNull
    public String getRuta() {
        return Ruta;
    }
    public void setRuta(@NonNull String Ruta) {
        this.Ruta = Ruta;
    }

}
