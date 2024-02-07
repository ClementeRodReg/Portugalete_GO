package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.portugaletego.modelo.Respuesta;

import java.util.List;

@Dao
public interface DAORespuesta {
    @Query("Select * from respuesta")
    List<Respuesta> obtenerRespuestas();

    @Query("Select * from respuesta where id = :id")
    Respuesta obtenerRespuesta(int id);

    @Query("Select * from respuesta where id_pregunta = :id_pregunta")
    List<Respuesta> obtenerRespuestasporPregunta(int id_pregunta);

    @Query("Select * from respuesta where EsCorrecto = 1")
    List<Respuesta> obtenerRespuestasCorrectas();

    @Insert
    void insertarRespuesta(Respuesta respuesta);

    @Query("UPDATE respuesta set texto = :texto, escorrecto = :correcto where id_pregunta = :id")
    void actualizarRespuesta(String texto, boolean correcto, int id);

    @Query("DELETE From respuesta where id = :id")
    void eliminarRespuesta(int id);
}