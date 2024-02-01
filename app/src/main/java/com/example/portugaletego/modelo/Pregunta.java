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
    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(@NonNull String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    @NonNull
    @ColumnInfo(name="textoPregunta")
    private String textoPregunta;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
