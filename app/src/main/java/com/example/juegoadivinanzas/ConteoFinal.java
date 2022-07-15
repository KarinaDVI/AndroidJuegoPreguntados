package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConteoFinal extends AppCompatActivity {


    private TextView tvFin,tvJugadorf;
    private TextView conteof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo_final);
        tvJugadorf = (TextView) findViewById(R.id.tvJugadorf);
        tvFin = (TextView) findViewById(R.id.tvPuntajef);

        String nombre = getIntent().getStringExtra("nombre");
        String puntaje = getIntent().getStringExtra("puntaje");

        tvJugadorf.setText("Jugador " + nombre);
        tvFin.setText("Puntaje Final: "+puntaje);

    }
    public void regresar (View view){
        Intent i = new Intent(this, Nivel3.class);
        startActivity(i);
    }
    public void reiniciar (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}