package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Nivel2 extends AppCompatActivity {

    private TextView tvNombre2;
    private TextView tvPuntos2;
    private RadioButton ck100, cknunca, ckbueno, ckojos;
    private int puntos2;
    private Button btnSigu2,btnR2;
    private TextView tvResp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);
        ck100 = (RadioButton) findViewById(R.id.rbQue100);
        cknunca = (RadioButton) findViewById(R.id.rbTarde);
        ckbueno = (RadioButton) findViewById(R.id.rbBueno);
        ckojos = (RadioButton) findViewById(R.id.rbCuervos);

        tvNombre2= (TextView)findViewById(R.id.etJugador2);
        tvPuntos2= (TextView)findViewById(R.id.tvPuntaje2);
        tvResp2 = (TextView)findViewById(R.id.tvRespuesta2);
        btnSigu2 = (Button)findViewById(R.id.btnS2);
        btnR2 = (Button)findViewById(R.id.btnRta2);

        btnSigu2.setVisibility(View.INVISIBLE);

        String nombre = getIntent().getStringExtra("nombre");
        String puntaje = getIntent().getStringExtra("puntaje");

        puntos2 = Integer.parseInt(puntaje);

        tvNombre2.setText(nombre);
        tvPuntos2.setText(puntaje);
    }
    public void puntaje (View view){
        if (ckbueno.isChecked() == true) {
            puntos2 += 10;
            tvPuntos2.setText(String.valueOf(puntos2));
            tvResp2.setText("Felicitaciones, Respondiste bien!" );
            btnSigu2.setVisibility(View.VISIBLE);
            btnR2.setEnabled(false);
        }else{
            tvPuntos2.setText(String.valueOf(puntos2));
        }
    }
    public void adelante (View view){
        Intent i = new Intent (this, Nivel3.class);
        i.putExtra("puntaje", tvPuntos2.getText().toString());
        i.putExtra("nombre", tvNombre2.getText().toString());
        startActivity(i);
    }
    public void regresar (View view){
        Intent i = new Intent(this, Nivel1.class);
        startActivity(i);
    }
}