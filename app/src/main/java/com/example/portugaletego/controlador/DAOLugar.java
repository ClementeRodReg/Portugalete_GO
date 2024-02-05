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

    //--------------------------------------------------------------------------------------------------
    @Query("Select * from lugar")
    List<Lugar> obtenerLugares();

    @Query("Select * from lugar where nombre = :nombre")
    Lugar obtenerLugar(String nombre);

    //   @Insert
    //   void insertarLugar(Lugar lugar);

    @Query("UPDATE lugar set nombre = :nombre, textoLugar = :texto, lat = :lat, lon = :lon where nombre = :nombre")
    void actualizarLugar(String nombre, String texto, String lat, String lon);

    @Query("DELETE From lugar where nombre = :nombre")
    void eliminarLugar(String nombre);
}
