package com.personajes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.quizledt.R;

public class MainActivity extends Activity implements View.OnClickListener {

    public CheckBox check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        check1 = (CheckBox)findViewById(R.id.volumen);
        check2 = (CheckBox)findViewById(R.id.vibracion);
        check3 = (CheckBox)findViewById(R.id.efectos);
    }

    public void onClick(View v){

        // Comprueba si el boton pulsado y la pantalla que carga
        switch (v.getId()){

            case R.id.inicio_inicio:

                break;

            case R.id.inicio_razas:
                setContentView(R.layout.razas_layout);
                break;

            case R.id.inicio_opciones:
                setContentView(R.layout.opciones_layout);
                break;

            case R.id.inicio_salir:
                System.exit(0);
                break;

            case R.id.btn_atras:
                setContentView(R.layout.main_layout);
                break;

            case R.id.inicio_quiz:
                Log.i("error", "llamada a la pantalla");
                Intent intent = new Intent(MainActivity.this, Quiz.class);
                startActivity(intent);
                break;
        }
    }

    public void onCheckboxClicked(View v){

        boolean checked = ((CheckBox) v).isChecked();

        // Comprueba si esta chekeado el checkbox
        switch(v.getId()) {
            case R.id.volumen:
                if (checked){

                }else{
                    break;
                }
            case R.id.vibracion:
                if (checked){

                }else{
                    break;
                }
            case R.id.efectos:
                if (checked){

                }else{
                    break;
                }
        }
    }
}
