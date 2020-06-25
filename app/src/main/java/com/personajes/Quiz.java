package com.personajes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quizledt.R;



/**
 * Created by Engueru on 02/06/2018.
 */

public class Quiz extends Activity {

    private TextView tvpregunta;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        tvpregunta = (TextView) findViewById(R.id.TvQuizPegunta);

    }

}
