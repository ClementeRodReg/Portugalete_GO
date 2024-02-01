package com.example.portugaletego.controlador;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.portugaletego.modelo.Grupo;

import java.util.List;

@Dao
public interface DAOGrupo {

    @Insert
    void InsertGrupo(Grupo grupo);

    @Query("SELECT * FROM Grupo")
    List<Grupo> obtenerUsuarios();

    @Query("SELECT * FROM Grupo where id = :id")
    List<Grupo> obtenerUsuarios(int id);
}
