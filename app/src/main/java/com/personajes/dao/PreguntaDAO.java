package com.personajes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.personajes.entities.Grupo;
import com.personajes.entities.Pregunta;

import java.util.List;

@Dao
public interface PreguntaDAO {

    @Query("SELECT * FROM pregunta")
    List<Pregunta> getAll();

    @Query("SELECT * FROM pregunta WHERE id_pregunta IN (:preguntasIds)")
    List<Pregunta> loadAllByIds(int[] preguntasIds);

    @Insert
    void insertAll(Pregunta... pregunta);

    @Delete
    void delete(Pregunta pregunta);
}
