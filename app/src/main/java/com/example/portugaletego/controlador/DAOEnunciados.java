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

    //--------------------------------------------------------------------------------------------------
    //    @Query("Select * from enunciados")
    //    List<Enunciados> obtenerEnunciados();

    @Query("Select * from enunciados where id_enunciado = :id")
    Enunciados obtenerEnunciado(int id);

    //   @Insert
    //   void insertarEnunciado(Enunciados enunciados);

    @Query("UPDATE enunciados set texto = :texto where id_enunciado = :id")
    void actualizarEnunciado(String texto, int id);

    @Query("DELETE From enunciados where id_enunciado = :id")
    void eliminarEnunciado(int id);


    @Query("SELECT * From enunciados LIMIT :cantidad OFFSET :inicio")
    List<Enunciados> obtenerEnunciadosEntre(int cantidad, int inicio);

    @Query("SELECT * from enunciados WHERE id_lugar = :id_lugar")
    List<Enunciados> obtenerEnunciadosPorIdLugar(int id_lugar);
}
