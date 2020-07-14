package com.personajes.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.personajes.entities.Pregunta;
import com.personajes.entities.Respuesta;

import java.util.List;

@Dao
public interface RespuestaDAO {

    // LiveData es una clase de titular de datos que se puede observar dentro de un ciclo de vida determinado.
    // Siempre almacena / almacena en caché la última versión de los datos. Notifica a sus observadores activos cuando el
    // los datos han cambiado. Como estamos obteniendo todos los contenidos de la base de datos,
    // se nos notifica cada vez que alguno de los contenidos de la base de datos ha cambiado.
    @Query ( " SELECT * from respuesta" )
    LiveData<List<Respuesta>> getAll ();

    @Query("DELETE FROM respuesta")
    void deleteAll();

    //@Query("SELECT * FROM respuesta")
    //List<Respuesta> getAll();

    @Query("SELECT * FROM respuesta WHERE id_respuesta IN (:respuestasIds)")
    List<Respuesta> loadAllByIds(int[] respuestasIds);

    @Insert
    void insertAll(Respuesta... respuesta);

    @Delete
    void delete(Respuesta respuesta);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Respuesta respuesta);
}
