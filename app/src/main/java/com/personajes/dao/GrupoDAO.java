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
public interface GrupoDAO {

    // LiveData es una clase de titular de datos que se puede observar dentro de un ciclo de vida determinado.
    // Siempre almacena / almacena en caché la última versión de los datos. Notifica a sus observadores activos cuando el
    // los datos han cambiado. Como estamos obteniendo todos los contenidos de la base de datos,
    // se nos notifica cada vez que alguno de los contenidos de la base de datos ha cambiado.
    @Query ( " SELECT * from grupo" )
    LiveData<List<Grupo>> getAll ();

    @Query("DELETE FROM grupo")
    void deleteAll();

    //@Query("SELECT * FROM grupo")
    //List<Grupo> getAll();

    @Query("SELECT * FROM grupo WHERE id_grupo IN (:gruposIds)")
    List<Grupo> loadAllByIds(int[] gruposIds);

    @Insert
    void insertAll(Grupo... grupo);

    @Delete
    void delete(Grupo grupo);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Grupo grupo);
}
