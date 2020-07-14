package com.personajes.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.personajes.entities.Grupo;
import com.personajes.entities.Pregunta;

import java.util.List;

@Dao
public interface PreguntaDAO {

    // LiveData es una clase de titular de datos que se puede observar dentro de un ciclo de vida determinado.
    // Siempre almacena / almacena en caché la última versión de los datos. Notifica a sus observadores activos cuando el
    // los datos han cambiado. Como estamos obteniendo todos los contenidos de la base de datos,
    // se nos notifica cada vez que alguno de los contenidos de la base de datos ha cambiado.
    @Query ( " SELECT * from pregunta" )
    LiveData<List<Pregunta>> getAll ();

    @Query("DELETE FROM pregunta")
    void deleteAll();

    //@Query("SELECT * FROM pregunta")
    //List<Pregunta> getAll();

    @Query("SELECT * FROM pregunta WHERE id_pregunta IN (:preguntasIds)")
    List<Pregunta> loadAllByIds(int[] preguntasIds);

    @Insert
    void insertAll(Pregunta... pregunta);

    @Delete
    void delete(Pregunta pregunta);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pregunta pregunta);
}
