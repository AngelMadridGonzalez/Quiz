package com.personajes.dao;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.personajes.bean.QuizBean;

/**
 * Created by Engueru on 02/06/2018.
 */

public class QuizDao {

    Gson gson = new Gson();

    public QuizBean getQuestion(String helperResult){
        Log.i("1", "cargarPregunta: "+ helperResult);
        try {
            if(helperResult.contains("Array"))
                helperResult = helperResult.replaceAll("Array","");
            JSONObject json= new JSONObject(helperResult);
            JSONArray ja= json.getJSONArray("usuario");
            QuizBean[] result= gson.fromJson(ja.toString(),QuizBean[].class);
            return result[0];
        } catch (JSONException e) { e.printStackTrace(); }
        return null;
    }
}
