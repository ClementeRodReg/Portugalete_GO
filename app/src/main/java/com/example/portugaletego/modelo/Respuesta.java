package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Pregunta.class,
        parentColumns = "id_pregunta",childColumns = "id_pregunta")})
public class Respuesta {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;

    @NonNull
    @ColumnInfo(name="Texto")
    private String texto;

    @NonNull
    @ColumnInfo(name="EsCorrecto")
    private boolean iscorrect;

    @NonNull
    @ColumnInfo(name="id_pregunta")
    private int id_pregunta;

    public int getId() {
        return id;
    }

    public Respuesta(int id, @NonNull String texto, boolean iscorrect, int id_pregunta) {
        this.id = id;
        this.texto = texto;
        this.iscorrect = iscorrect;
        this.id_pregunta = id_pregunta;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTexto() {
        return texto;
    }

    public void setTexto(@NonNull String texto) {
        this.texto = texto;
    }

    public boolean isIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }
}
