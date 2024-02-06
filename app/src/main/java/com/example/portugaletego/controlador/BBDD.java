package com.example.portugaletego.controlador;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.portugaletego.modelo.Enunciados;
import com.example.portugaletego.modelo.Grupo;
import com.example.portugaletego.modelo.Imagen;
import com.example.portugaletego.modelo.Lugar;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Respuesta;

@Database(
        version = 4,
        entities = {
                Grupo.class,
                Respuesta.class,
                Pregunta.class,
                Lugar.class,
                Imagen.class,
                Enunciados.class}
)
public abstract class BBDD extends RoomDatabase {
        public abstract DAOGrupo daoGrupo();
        public abstract DAORespuesta daoRespuesta();
        public abstract DAOPregunta daoPregunta();
        public abstract DAOLugar daoLugar();
        public abstract DAOImagen daoImagen();
        public abstract DAOEnunciados daoEnunciados();
        public abstract DAOPuntuacion daoPuntuacion();

        private static volatile BBDD INSTANCE;

        public static BBDD getDatabase(final Context context) {
                if (INSTANCE == null) {
                        synchronized (BBDD.class) {
                                if (INSTANCE == null) {
                                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BBDD.class, "bd_portu").allowMainThreadQueries().build();
                                }
                        }
                }
                return INSTANCE;
        }
}
