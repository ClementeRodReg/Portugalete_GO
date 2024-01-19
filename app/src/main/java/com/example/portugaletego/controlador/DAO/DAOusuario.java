package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.portugaletego.modelo.Usuario;

import java.util.List;

@Dao
public interface DAOusuario {

    @Query("SELECT * FROM Usuario")
    List<Usuario> obtenerUsuarios();

    @Query("SELECT * FROM Usuario where id = :id")
    List<Usuario> obtenerUsuarios(int id);
}
