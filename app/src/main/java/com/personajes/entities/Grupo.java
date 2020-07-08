package com.personajes.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "grupo")
public class Grupo {

    @PrimaryKey
    @ColumnInfo(name = "id_grupo")
    public int idGrupo;

    @ColumnInfo(name = "texto_grupo")
    public String textoGrupo;

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTextoGrupo() {
        return textoGrupo;
    }

    public void setTextoGrupo(String textoGrupo) {
        this.textoGrupo = textoGrupo;
    }
}
