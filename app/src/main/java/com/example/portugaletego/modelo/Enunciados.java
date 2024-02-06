package com.example.portugaletego.modelo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey( entity = Lugar.class,
        parentColumns = "id_lugar",
        childColumns = "id_lugar",
        onDelete = ForeignKey.CASCADE)})
public class Enunciados {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id_enunciado")
    private int id_enunciado;

    @NonNull
    @ColumnInfo(name="texto")
    private String texto;

    @NonNull
    @ColumnInfo(name="id_lugar")
    private int id_lugar;

    @NonNull
    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(@NonNull int id_lugar) {
        this.id_lugar = id_lugar;
    }


    public int getId_enunciado() {
        return id_enunciado;
    }

    public void setId_enunciado(int id_enunciado) {
        this.id_enunciado = id_enunciado;
    }

    @NonNull
    public String getTexto() {
        return texto;
    }

    public void setTexto(@NonNull String texto) {
        this.texto = texto;
    }

    public Enunciados(int id_enunciado, String texto, @NonNull int idLugar){
        this.id_enunciado = id_enunciado;
        this.texto = texto;
        id_lugar = idLugar;
    }

    public static String textos[] ={
          "Ejercicio 1: Empareja las palabras con las fotos correspondientes",
          "Ejercicio 2: Responde las preguntas",
          "Ejercicio 3: Mira esta imagen y saca una foto del lugar correspondiente"
    };

    public static String juego4[] ={
            "Ejercicio 4: Saca una foto a un Basa Lore",
            "Encuentra un arbol, describe sus cualidades y sacale una foto",
            "Encuentra una piedra que tenga una forma especial o solo un color, sacale una foto",
            "Graba un video que tenga que ver con la historia de la Florida",
            "Saca una foto a un ave de la zona."
    };

    public static String juego3[] ={
            "La torre de Salazar fue construida alrededor de 1380 en Portugalete",
            "Tras la quema de 1943 realizada por los anarquistas, no quedaron mas que ruinas y la biblioteca se perdío",
            "En los años 1958/1959, el arquitecto Joaquin Irizar reconstruyo la torre",
            "La construccion se divide en dos: por un lado, la torre, por otro, la muralla",
            "La ultima reconstrucción fue en 2003, con el objetivo que puso el ayuntamiento para utilizarla de centro cultural"
    };

}
