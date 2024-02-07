package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.controlador.ControladorPasarVentana;
import com.example.portugaletego.modelo.Enunciados;
import com.example.portugaletego.modelo.Grupo;
import com.example.portugaletego.modelo.Lugar;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Puntuacion;
import com.example.portugaletego.modelo.Respuesta;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Intent mandar;
    final Handler handler = new Handler();
    final int delay = 50;

    BBDD appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControladorPasarVentana pasarVentana = new ControladorPasarVentana(MainActivity.this, ActivitySeleccion.class);

        appDatabase = BBDD.getDatabase(getApplicationContext()); //obtenemos la base de datos

        if(!existeBaseDeDatos(this, "bd_portu4")){
            INSERTS();
        }


        handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    mandar = pasarVentana.getMandar();
                    startActivity(mandar);

                } catch (Exception ex) {
                }
                if (pasarVentana.getContador() < 1)
                    handler.postDelayed(this, delay);

            }
        }, delay);

    }

    public void INSERTS(){
        //INSERTS GRUPOS
        appDatabase.daoGrupo().insertarGrupo(new Grupo(1, "Grupo 1"));
        appDatabase.daoGrupo().insertarGrupo(new Grupo(2, "Grupo 2"));
        appDatabase.daoGrupo().insertarGrupo(new Grupo(3, "Grupo 3"));
        //inserts Lugares
        appDatabase.daoLugar().insertarLugar(new Lugar("Puente Colgante","El Puente de Vizcaya, también conocido como Puente Bizkaia, " +
                "Puente colgante, Puente de Portugalete, " +
                "o Puente colgante de Portugalete, es un puente transbordador de peaje, concebido, diseñado y " +
                "construido por iniciativa privada entre 1887 y 1893, que une las dos márgenes de la ría de Bilbao en Vizcaya.",43.32280702415836, -3.017871992540378, 0));
        appDatabase.daoLugar().insertarLugar(new Lugar("Museo Rialia","Según documentos conservados en el Archivo Histórico de Portugalete, " +
                "ya en el año 1892 competía una trainera de Portugalete en la regata entre cofradías, " +
                "y por lo tanto ya no podemos considerar como primera constancia escrita aquella que habla de una tripulación local compitiendo en 1917. " +
                "Es en 1917 cuando se inician las regatas del Abra, quedando las tripulaciones en el orden siguiente: " +
                "Santurtzi, Portugalete, Zierbena y Algorta. La trainera portugaluja se llamaba “Engracia“.",43.318723256749124, -3.0140295609217365, 1));
        appDatabase.daoLugar().insertarLugar(new Lugar("Torre Salazar","La casa torre de Salazar, es una casa torre del siglo xiv, " +
                "construida hacia 1380 en mampostería y se sitúa en la Villa de Portugalete (Vizcaya). " +
                "Perteneció al linaje de los Salazar. ",43.320139896048985, -3.0170681032500877, 2));
        appDatabase.daoLugar().insertarLugar(new Lugar("Campo de Futbol La Florida","según las fuentes históricas consultadas, remonta sus orígenes a 1909 cuando es fundado por su primer Presidente, " +
                "Alfredo Hervias, y se federa con el nombre de Deportivo Portugalete.\n" +
                "A partir de ese nacimiento, pasamos a exponer los datos más relevantes y/o anecdóticos de la Historia del Club, cronológicamente ordenados por sus décadas de vida, " +
                "y estableciendo un bonito paralelismo con la situación de la Noble Villa de Portugalete en cada época.",43.31826126075431, -3.026257332581579, 3));

        //inserts enunciados
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(0,"Ejercicio 1: Empareja las palabras con las fotos correspondientes", 0));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(1,"Ejercicio 2: Responde las preguntas", 1));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(2,"Ejercicio 3: Saca una foto del lugar correspondiente", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(3,"Ejercicio 4: Saca una foto a un Basa Lore", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(4,"Encuentra un arbol, describe sus cualidades y sacale una foto", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(5,"Encuentra una piedra que tenga una forma especial o solo un color, sacale una foto", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(6,"Graba un video que tenga que ver con la historia de la Florida", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(7,"Saca una foto a un ave de la zona.", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(8,"La torre de Salazar fue construida alrededor de 1380 en Portugalete", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(9,"Tras la quema de 1943 realizada por los anarquistas, no quedaron mas que ruinas y la biblioteca se perdío", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(10,"En los años 1958/1959, el arquitecto Joaquin Irizar reconstruyo la torre", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(11,"La construccion se divide en dos: por un lado, la torre, por otro, la muralla", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(12,"La ultima reconstrucción fue en 2003, con el objetivo que puso el ayuntamiento para utilizarla de centro cultural", 2));
        //insert Preguntas
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(0, "¿Qué o quién es el Patrón?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(1, "¿Cuantos remeros hay en una trainera?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(2, "¿Quién ha ganado la liga de 2023?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(3, "¿Como se llama el equipo de Portugalete?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(4, "¿Qué se pescaba con las traineras?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(5, "¿Cuando comenzo la industrialización en España?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(6, "¿Qué ciudad no es de la margen izquierda?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(7, "¿Cual fue la industra principal en la margen izquierda?",1));
        //insert Respuestas[0]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(0,"La persona que daba las instrucciones fuera del agua",false,1));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(1,"La persona que estaba en la parte trasera de la trainera, corrigiendo el rumbo",true,1));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(2,"La persona que va al lado de la trainera en un bote",false,1));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(3,"El mas anciano de los remeros",false,1));
        //insert Respuestas[1]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(4,"11",false,2));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(5,"16",false,2));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(6,"14",false,2));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(7,"13",true,2));
        //Insert Respuestas[2]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(8,"Nikolas Deuna",false,3));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(9,"Portugaletetarrak",false,3));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(10,"Jarrillera",true,3));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(11,"Piratas de Sombrero de Paja",false,3));
        //Insert Respuestas[3]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(12,"Ballenas",true,4));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(13,"Sardinas",false,4));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(14,"Merluzas",false,4));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(15,"Bacalao",false,4));
        //Insert REspuestas[4]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(16,"1790-1800",false,5));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(17,"1850-1900",false,5));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(18,"1800-1850",true,5));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(19,"1900+",false,5));
        //Insert REspuestas[5]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(20,"Trapagaran",true,6));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(21,"Barakaldo",false,6));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(22,"Sestao",false,6));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(23,"Bilbao",false,6));
        //Insert REspuestas[6]
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(24,"Pesca",false,7));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(25,"Astilleros",false,7));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(26,"Siderurgia",true,7));
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta(27,"Mercaderia",false,7));
        //Insert Puntuaciones de BASE
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo1_06_02_2024",20));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo2_06_02_2024",19));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo3_06_02_2024",18));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo1_03_02_2024",17));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo2_03_02_2024",16));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo3_03_02_2024",15));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo1_04_02_2024",14));
        appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion("Grupo1_07_02_2024",13));
    }

    private boolean existeBaseDeDatos(Context context, String nombreDb) {
        File dbFile = context.getDatabasePath(nombreDb);

        return dbFile.exists();
    }
}