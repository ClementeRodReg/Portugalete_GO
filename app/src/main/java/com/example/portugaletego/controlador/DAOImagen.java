package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.portugaletego.modelo.Imagen;
import com.example.portugaletego.modelo.Lugar;

import java.util.List;

@Dao
public interface DAOImagen {

    @Insert
    void insertarImagen(Imagen img);

    @Update
    void updateImagen(Imagen img);

    @Delete
    void deleteImagen(Imagen img);

    @Query("Select * from Imagen")
    List<Imagen> obtenerImagenAll();

    @Query("Select * from Imagen where Id = :nombreImagen")
    List<Imagen> obtenerImagenPorNombre(String nombreImagen);

}
