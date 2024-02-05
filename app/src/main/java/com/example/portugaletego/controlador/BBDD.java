package com.example.portugaletego.controlador;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.portugaletego.modelo.Grupo;
import com.example.portugaletego.modelo.Imagen;
import com.example.portugaletego.modelo.Lugar;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Respuesta;

@Database(
        version = 1,
        entities = {Grupo.class, Respuesta.class, Pregunta.class,
        Lugar.class, Imagen.class        }
)
public abstract class BBDD extends RoomDatabase {
        public abstract DAOGrupo daoUsuario();
}
