package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Nivel3 extends AppCompatActivity {


    private Spinner opcion;
    private TextView tvNombre3;
    private TextView tvPuntos3;
    private TextView tvResp3;
    private int puntos3;
    private Button btnSigu3,btnR3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);

        opcion = (Spinner) findViewById(R.id.spinnerM);
        tvNombre3 = (TextView) findViewById(R.id.etJugador3);
        tvPuntos3 = (TextView) findViewById(R.id.tvPuntaje3);
        tvResp3 = (TextView) findViewById(R.id.tvRespuesta3);
        btnSigu3 = (Button)findViewById(R.id.btnS3);
        btnR3 = (Button)findViewById(R.id.btnRta3);

        btnSigu3.setVisibility(View.INVISIBLE);

        // Cargar el Spinner
        String[] opciones = {"","Cerro Tronador","Everest","Aconcagua","Volcan Lanín","Chimborazo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinnerlayout,opciones);
        opcion.setAdapter(adapter);

        String nombre = getIntent().getStringExtra("nombre");
        String puntaje = getIntent().getStringExtra("puntaje");

        puntos3 = Integer.parseInt(puntaje);

        tvNombre3.setText(nombre);
        tvPuntos3.setText(puntaje);

    }
    public void puntaje3(View view){
        String selected = opcion.getSelectedItem().toString();
        if (selected.equals("Aconcagua")==true) {
            puntos3 += 10;
            tvPuntos3.setText(String.valueOf(puntos3));
            tvResp3.setText("Felicitaciones, Respondiste bien!" );
            btnSigu3.setVisibility(View.VISIBLE);
            btnR3.setEnabled(false);
        }else{
            tvPuntos3.setText(String.valueOf(puntos3));
        }
    }
    public void adelante (View view){
        Intent i = new Intent (this, ConteoFinal.class);
        i.putExtra("puntaje", tvPuntos3.getText().toString());
        i.putExtra("nombre", tvNombre3.getText().toString());
        startActivity(i);
    }
    public void regresar (View view){
        Intent i = new Intent(this, Nivel2.class);
        startActivity(i);
    }

}