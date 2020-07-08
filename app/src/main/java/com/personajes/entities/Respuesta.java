package com.personajes.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Respuesta {

    @PrimaryKey
    @ColumnInfo(name = "id_respuesta")
    public int idRespuesta;

    //@ForeignKey()
    //public int idGrupo;

    @ColumnInfo(name = "texto_respuesta")
    public String textoRespuesta;

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }
}
