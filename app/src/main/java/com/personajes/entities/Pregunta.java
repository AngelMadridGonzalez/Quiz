package com.personajes.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Pregunta {

    @PrimaryKey
    @ColumnInfo(name = "id_pregunta")
    public int id;

    //@ForeignKey()
    //public int idRespuesta;

    @ColumnInfo(name = "texto_pregunta")
    public String textoRespuesta;


    public Pregunta(int id, String textoRespuesta) {
        this.id = id;
        this.textoRespuesta = textoRespuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }
}
