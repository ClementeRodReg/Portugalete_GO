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
public class Pregunta {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id_pregunta")
    private int id_pregunta;

    @NonNull
    @ColumnInfo(name="textoPregunta")
    private String textoPregunta;

    @NonNull
    @ColumnInfo(name="id_enunciado")
    private String id_enunciado;

    public Pregunta(int id_pregunta, String textoPregunta, String id_enunciado){
        this.id_pregunta = id_pregunta;
        this.textoPregunta = textoPregunta;
        this.id_enunciado = id_enunciado;
    }

    @NonNull
    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(@NonNull String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    @NonNull
    public int getId() {
        return id_pregunta;
    }

    public void setId(@NonNull int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }
}
