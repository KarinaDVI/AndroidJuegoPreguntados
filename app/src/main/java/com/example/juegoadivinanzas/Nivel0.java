package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Nivel0 extends AppCompatActivity {

    private TextView tvNombre0;
    private TextView tvPuntos0;
    private RadioButton ckRo, ckPa, ckRg, ckSr;
    private TextView tvResp0 ;
    private Button btnSigu0,btnR0;
    private ImageButton btnStar;

    int puntos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel0);

        tvNombre0= (TextView)findViewById(R.id.etJugador0);
        tvPuntos0= (TextView)findViewById(R.id.tvPuntaje1);
        tvResp0 = (TextView) findViewById(R.id.tvRespuesta0);
        btnSigu0 = (Button)findViewById(R.id.btnS0);
        btnR0 = (Button)findViewById(R.id.btnRta0);
        btnStar = (ImageButton) findViewById(R.id.btnStar);

        String nombre = getIntent().getStringExtra("nombre");
        tvNombre0.setText("Juega " + nombre);
        tvPuntos0.setText("Puntaje: "+"0");
        btnSigu0.setVisibility(View.INVISIBLE);
        btnStar.setVisibility(View.INVISIBLE);

        ckRo = (RadioButton) findViewById(R.id.rbRosario);
        ckPa = (RadioButton) findViewById(R.id.rbParana);
        ckRg = (RadioButton) findViewById(R.id.rbRioGallegos);
        ckSr = (RadioButton) findViewById(R.id.rbSantaRosa);
    }
    public void puntaje(View view) {

        if (ckRg.isChecked() == true) {
            puntos += 10;
            tvPuntos0.setText(String.valueOf(puntos));
            tvResp0.setText("Felicitaciones, Respondiste bien!" );
            btnStar.setVisibility(View.VISIBLE);
            btnSigu0.setVisibility(View.VISIBLE);
            btnR0.setEnabled(false);

        }else{
            tvPuntos0.setText(String.valueOf(puntos));
            tvResp0.setText("Incorrecto, Probá de nuevo!" );
        }
    }

    public void adelante (View view){
        Intent i = new Intent (this, Nivel1.class);
        i.putExtra("puntaje", tvPuntos0.getText().toString());
        i.putExtra("nombre", tvNombre0.getText().toString());
        startActivity(i);
    }
    public void regresar (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}