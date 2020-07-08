package com.personajes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.personajes.entities.Respuesta;

import java.util.List;

@Dao
public interface RespuestaDAO {

    @Query("SELECT * FROM respuesta")
    List<Respuesta> getAll();

    @Query("SELECT * FROM respuesta WHERE id_respuesta IN (:respuestasIds)")
    List<Respuesta> loadAllByIds(int[] respuestasIds);

    @Insert
    void insertAll(Respuesta... respuesta);

    @Delete
    void delete(Respuesta respuesta);
}
