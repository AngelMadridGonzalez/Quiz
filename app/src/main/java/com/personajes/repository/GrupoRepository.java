package com.personajes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.personajes.dao.GrupoDAO;
import com.personajes.entities.Grupo;
import com.personajes.entities.Respuesta;

import java.util.List;

public class GrupoRepository {

    private GrupoDAO mGrupoDao;
    private LiveData<List<Grupo>> mAllGrupos;

    GrupoRepository(Application application){
        CommonRoomDatabase db = CommonRoomDatabase.getDatabase(application);
        mGrupoDao = db.grupoDAO();

        //Aqui pondremos lo que queremos que nos devuelva
        mAllGrupos = mGrupoDao.getAll();
    }

    //Obtener todos los grupos
    LiveData<List<Grupo>> getAllRespuestas() {
        return mAllGrupos;
    }

    //Insertar todos los grupos
    void insert(Grupo grupo) {
        CommonRoomDatabase.databaseWriteExecutor.execute(() -> {
            mGrupoDao.insert(grupo);
        });
    }
}
