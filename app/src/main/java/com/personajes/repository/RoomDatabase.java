package com.personajes.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.personajes.dao.GrupoDAO;
import com.personajes.dao.PreguntaDAO;
import com.personajes.dao.RespuestaDAO;
import com.personajes.entities.Grupo;
import com.personajes.entities.Pregunta;
import com.personajes.entities.Respuesta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Grupo.class, Pregunta.class, Respuesta.class}, version = 1, exportSchema = false)
abstract class CommonRoomDatabase extends RoomDatabase {

    abstract GrupoDAO grupoDAO();
    abstract PreguntaDAO preguntaDAO();
    abstract RespuestaDAO respuestaDAO();

    private static volatile CommonRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static CommonRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CommonRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CommonRoomDatabase.class, "quiz_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Borramos la base de datos cada vez que se crea o se abre.
     * Si desea llenar la base de datos solo cuando la base de datos se crea por primera vez,
     * anular override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // Si desea mantener los datos a través de reinicios de aplicaciones,
            // comenta el siguiente bloque
            databaseWriteExecutor.execute(() -> {

                // Rellena la base de datos en segundo plano.

                //Primero eliminamos los datos
                PreguntaDAO dao = INSTANCE.preguntaDAO();
                dao.deleteAll();

                //Después insertamos los datos, estos son datos de prueba
                //Habrá que mirar como lanzar un scrpt para que automatice todas las preguntas, respuestas y grupos de una sola vez
                Pregunta pregunta = new Pregunta(1,"¿Hola?");
                dao.insert(pregunta);
                pregunta = new Pregunta(2,"¿Adios?");
                dao.insert(pregunta);
            });
        }
    };
}
