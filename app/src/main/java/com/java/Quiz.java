package com.java;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class Quiz extends Activity {

    private TextView tvpregunta;
    private final String URL_WEBSERVICE = "http://www.laeradeltitan.com/getQuestion.php";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        cargarPreguntas("1","cargarPregunta");

        tvpregunta = (TextView) findViewById(R.id.TvQuizPegunta);

    }

    public void cargarPreguntas(String param, String tag){
        Log.i("error", "cargarPreguntas");
        HashMap<String, String> params= new HashMap<>();
        params.put("url",URL_WEBSERVICE);
        params.put("tag",tag);
        params.put("id", param);
        Quiz.AsyncHttpTask task = new Quiz.AsyncHttpTask();
        task.execute(params);
    }

    public class AsyncHttpTask extends AsyncTask<HashMap<String,String>, Void, String> {

        //DURANTE EL PROCESO...
        @Override
        protected String doInBackground(HashMap<String, String>... params) {
            Log.i("error", "AsyncHttpTask");
            //EJECUTAMOS LA CLASE HANDLER QUE LLAMA AL SERVIDOR JUNTO CON LOS PARAMETROS QUE HEMOS INTRODUCIDO
            HttpHandler handler = new HttpHandler();
            String url = params[0].get("url");
            params[0].remove("url");
            String response = handler.mainPerformPostCall(url, params[0]);
            Log.i("error", "Aqui la respuesta al asynctask : "+response);
            return response;
        }

        //UNA VEZ FINALIZADO EL PROCESO Y CARGADO EL STRING DE RESULTADO...
        @Override
        protected void onPostExecute(String result) {
            //SI OBTENEMOS RESULTADO..
            if (result.length() > 0) {
                QuizDao qDAO = new QuizDao();
                QuizBean bean = qDAO.getQuestion(result);
                //tvpregunta.setText(bean.getDescription_answer()+"");
            } else {
                Log.i("error", "no cargaron los datos!");
            }
        }
    }
}