package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Lugar;

import java.util.List;

@Dao
public interface DAOLugar {

    @Insert
    void insertarLugar(Lugar lugar);

    @Update
    void updateLugar(Lugar lugar);

    @Delete
    void deleteLugar(Lugar lugar);

    @Query("Select * from Lugar where nombreL = :nombreLugar")
    List<Lugar> obtenerLugarPorNombre(String nombreLugar);
}
