package com.personajes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.personajes.entities.Grupo;

import java.util.List;

@Dao
public interface GrupoDAO {

    @Query("SELECT * FROM grupo")
    List<Grupo> getAll();

    @Query("SELECT * FROM grupo WHERE id_grupo IN (:gruposIds)")
    List<Grupo> loadAllByIds(int[] gruposIds);

    @Insert
    void insertAll(Grupo... grupo);

    @Delete
    void delete(Grupo grupo);
}
