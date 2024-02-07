package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Pregunta;

import java.util.List;

@Dao
public interface DAOPregunta {

    @Insert
    void insertarPreguntas(Pregunta pregunta);

    @Delete
    void deletePreguntas(Pregunta pregunta);

    @Update
    void updatePreguntas(Pregunta pregunta);

    @Query("Select * from Pregunta")
    List<Pregunta> obtenerPreguntas();

    //--------------------------------------------------------------------------------------------------
    //     @Query
    //     ("Select * from pregunta") List<Pregunta> obtenerPreguntas();

    @Query("Select * from pregunta where id_pregunta = :id")
    Pregunta obtenerPregunta(int id);

    @Insert
    void insertarPregunta(Pregunta pregunta);

    @Query("UPDATE pregunta set textoPregunta = :texto where id_pregunta = :id")
    void actualizarPregunta(String texto, int id);

    @Query("DELETE From pregunta where id_pregunta = :id")
    void eliminarPregunta(int id);
}
