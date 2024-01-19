package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Pregunta;

import java.util.List;

@Dao
public interface DAOPreguntas {
    @Insert
    void insert(Pregunta pregunta);

    @Delete
    void delete(Pregunta pregunta);

    @Update
    void update(Pregunta pregunta);

    @Query("SELECT * FROM pregunta")
    List<Pregunta> getAll();
}
