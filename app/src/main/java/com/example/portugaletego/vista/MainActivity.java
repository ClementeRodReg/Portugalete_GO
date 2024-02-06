package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.controlador.ControladorPasarVentana;
import com.example.portugaletego.modelo.Enunciados;
import com.example.portugaletego.modelo.Lugar;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Respuesta;

public class MainActivity extends AppCompatActivity {
    Intent mandar;
    final Handler handler = new Handler();
    final int delay = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControladorPasarVentana pasarVentana = new ControladorPasarVentana(MainActivity.this, ActivitySeleccion.class);

        BBDD appDatabase = BBDD.getDatabase(getApplicationContext()); //obtenemos la base de datos

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
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(2,"Ejercicio 3: Mira esta imagen y saca una foto del lugar correspondiente", 2));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(3,"Ejercicio 4: Saca una foto a un Basa Lore", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(4,"Encuentra un arbol, describe sus cualidades y sacale una foto", 4));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(5,"Encuentra una piedra que tenga una forma especial o solo un color, sacale una foto", 4));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(6,"Graba un video que tenga que ver con la historia de la Florida", 4));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(7,"Saca una foto a un ave de la zona.", 4));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(8,"La torre de Salazar fue construida alrededor de 1380 en Portugalete", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(9,"Tras la quema de 1943 realizada por los anarquistas, no quedaron mas que ruinas y la biblioteca se perdío", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(10,"En los años 1958/1959, el arquitecto Joaquin Irizar reconstruyo la torre", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(11,"La construccion se divide en dos: por un lado, la torre, por otro, la muralla", 3));
        appDatabase.daoEnunciados().insertarEnunciado(new Enunciados(12,"La ultima reconstrucción fue en 2003, con el objetivo que puso el ayuntamiento para utilizarla de centro cultural", 3));
        //insert Preguntas
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(0, "¿Qué o quién es el Patrón?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(1, "¿Cuantos remeros hay en una trainera?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(2, "¿Quién ha ganado la liga de 2023?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(3, "¿Como se llama el equipo de Portugalete?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(4, "¿Qué se pescaba con las traineras?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(5, "¿Cuando comenzo la industrialización en España?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(6, "¿Qué ciudad no es de la margen izquierda?",1));
        appDatabase.daoPregunta().insertarPregunta(new Pregunta(7, "¿Cual fue la industra principal en la margen izquierda?",1));
        //insert Respuestas
        appDatabase.daoRespuesta().insertarRespuesta(new Respuesta());


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
}