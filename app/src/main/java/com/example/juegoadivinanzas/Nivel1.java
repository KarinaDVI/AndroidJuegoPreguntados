package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Nivel1 extends AppCompatActivity {

    private TextView tvNombre1;
    private TextView tvPuntos1;
    private CheckBox checkb5, checkb7, checkb6, checkb9;
    private int puntos1;
    private Button btnSigu1, btnR1;
    private TextView tvResp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        checkb5 = (CheckBox) findViewById(R.id.cbx5);
        checkb7 = (CheckBox) findViewById(R.id.cbx7);
        checkb6 = (CheckBox) findViewById(R.id.cbx6);
        checkb9 = (CheckBox) findViewById(R.id.cbx9);

        tvNombre1 = (TextView) findViewById(R.id.etJugador1);
        tvPuntos1 = (TextView) findViewById(R.id.tvPuntaje1);
        tvResp1 = (TextView) findViewById(R.id.tvRespuesta1);
        btnSigu1 = (Button) findViewById(R.id.btnS1);
        btnR1 = (Button) findViewById(R.id.btnRta1);
        btnSigu1.setVisibility(View.INVISIBLE);

        String nombre = getIntent().getStringExtra("nombre");
        String puntaje = getIntent().getStringExtra("puntaje");

        puntos1 = Integer.parseInt(puntaje);

        tvNombre1.setText(nombre);
        tvPuntos1.setText(puntaje);
    }

    public void puntaje(View view) {
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;

        if (checkb6.isChecked() == true) {
            puntos1 += 10;
            tvPuntos1.setText(String.valueOf(puntos1));
            r1 = true;
        }
        if (checkb9.isChecked() == true) {
            puntos1 += 10;
            tvPuntos1.setText(String.valueOf(puntos1));
            r2 = true;
        }
        if (checkb5.isChecked() == true || checkb7.isChecked() == true) {
            r4 = true;
        }

        if ((r1 || r2) || (r1 && r2)) {
            r3 = true;
        }
        if ((r4 && r3) || r4) {
            tvResp1.setText("Te faltó algo o sobra algo, intentá de nuevo!");
        }else {
            tvResp1.setText("Felicitaciones, Respondiste bien!");
            btnSigu1.setVisibility(View.VISIBLE);
            btnR1.setEnabled(false);
        }
    }
        public void adelante (View view){
            Intent i = new Intent(this, Nivel2.class);
            i.putExtra("puntaje", tvPuntos1.getText().toString());
            i.putExtra("nombre", tvNombre1.getText().toString());
            startActivity(i);
        }
        public void regresar (View view){
            Intent i = new Intent(this, Nivel0.class);
            startActivity(i);
        }
    }
