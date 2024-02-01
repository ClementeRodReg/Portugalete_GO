package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Enunciados;
import com.example.portugaletego.modelo.Pregunta;

import java.util.List;

@Dao
public interface DAOEnunciados
{


    @Insert
    void insertarEnunciado(Enunciados en);

    @Delete
    void deleteEnunciado(Enunciados en);

    @Update
    void updatePreguntas(Enunciados en);

    @Query("Select * from Enunciados")
    List<Enunciados> obtenerEnunciados();
}
