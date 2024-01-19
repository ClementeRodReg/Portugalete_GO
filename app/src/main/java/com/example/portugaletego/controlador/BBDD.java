package com.example.portugaletego.controlador;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.portugaletego.controlador.DAO.DAOusuario;
import com.example.portugaletego.modelo.Coordenada;
import com.example.portugaletego.modelo.Imagen;
import com.example.portugaletego.modelo.Juego;
import com.example.portugaletego.modelo.Lugar;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Respuesta;
import com.example.portugaletego.modelo.Usuario;

@Database(
        version = 1,
        entities = {Usuario.class, Respuesta.class, Pregunta.class,
        Lugar.class, Juego.class, Imagen.class, Coordenada.class
        }
)
public abstract class BBDD extends RoomDatabase {

}
