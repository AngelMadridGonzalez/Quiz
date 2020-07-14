package com.personajes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.personajes.dao.PreguntaDAO;
import com.personajes.dao.RespuestaDAO;

import com.personajes.entities.Pregunta;
import com.personajes.entities.Respuesta;

import java.util.List;

public class RespuestaRepository {

    private RespuestaDAO mRespuestaDAO;
    private LiveData<List<Respuesta>> mAllRespuestas;

    RespuestaRepository(Application application){
        CommonRoomDatabase db = CommonRoomDatabase.getDatabase(application);
        mRespuestaDAO = db.respuestaDAO();

        //Aqui pondremos lo que queremos que nos devuelva
        mAllRespuestas = mRespuestaDAO.getAll();
    }

    //Obtener todas las respuestas
    LiveData<List<Respuesta>> getAllRespuestas() {
        return mAllRespuestas;
    }

    //Insertar todas las respuestas
    void insert(Respuesta respuesta) {
        CommonRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRespuestaDAO.insert(respuesta);
        });
    }
}
