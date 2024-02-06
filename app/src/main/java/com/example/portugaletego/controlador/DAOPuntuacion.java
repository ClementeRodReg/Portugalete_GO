package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Puntuacion;

import java.util.List;

@Dao
public interface DAOPuntuacion {
    @Insert
    void insertarPuntuacion(Puntuacion puntuacion);

    @Delete
    void borrarPuntuacion(Puntuacion puntuacion);

    @Query("UPDATE puntuacion set puntos = :puntos where puntuacion_id = :idpuntuacion")
    void actualizarPuntuacion(int puntos, String idpuntuacion);

    @Query("SELECT * from puntuacion")
    List<Puntuacion> obtenerRanking();
}
