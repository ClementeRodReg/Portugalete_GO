package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity
public class Imagen extends Contenido{

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



    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Id")
    private int id;

    @NonNull
    @ColumnInfo(name="Nombre")
    private String nombre;

    /*
    @NonNull
    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(@NonNull Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    @NonNull
    @ColumnInfo(name="Respuesta")
    private Respuesta respuesta;
*/

}
