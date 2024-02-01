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
}
