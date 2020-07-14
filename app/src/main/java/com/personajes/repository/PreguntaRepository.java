package com.personajes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.personajes.dao.PreguntaDAO;
import com.personajes.entities.Pregunta;

import java.util.List;

public class PreguntaRepository {

    private PreguntaDAO mPreguntaDAO;
    private LiveData<List<Pregunta>> mAllPreguntas;

    PreguntaRepository(Application application){
        CommonRoomDatabase db = CommonRoomDatabase.getDatabase(application);
        mPreguntaDAO = db.preguntaDAO();
        //Aqui pondremos lo que queremos que nos devuelva
        mAllPreguntas = mPreguntaDAO.getAll();
    }

    //Obtener todas las Preguntas
    LiveData<List<Pregunta>> getAllPreguntas() {
        return mAllPreguntas;
    }

    //Insertar todas las Preguntas
    void insert(Pregunta pregunta) {
        CommonRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPreguntaDAO.insert(pregunta);
        });
    }
}
