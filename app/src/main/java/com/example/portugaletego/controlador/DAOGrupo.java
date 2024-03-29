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

    @Query("SELECT * FROM Grupo where idGrupo = :id")
    List<Grupo> obtenerUsuarios(int id);

    //--------------------------------------------------------------------------------------------------

    @Query("Select * from grupo")
    List<Grupo> obtenerGrupos();

    @Query("Select * from grupo where idGrupo = :id")
    Grupo obtenerGrupo(int id);

    @Insert
    void insertarGrupo(Grupo grupo);

    @Query("UPDATE grupo set nombre = :nombre where idGrupo = :id")
    void actualizarGrupo(String nombre, int id);

    @Query("DELETE From grupo where idGrupo= :id")
    void eliminarGrupo(int id);
}
