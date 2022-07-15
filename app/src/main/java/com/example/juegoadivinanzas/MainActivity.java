package com.example.juegoadivinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private TextView puntaje;
    private TextView tvMsg;
    private Button btnInit;
    private int punto0=0;
    private String nombre0="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText)findViewById(R.id.eTextPersonName);
        puntaje = (TextView)findViewById(R.id.tvPuntajei);
        tvMsg = (TextView)findViewById(R.id.tvMensaje);

        btnInit = (Button)findViewById(R.id.btnInicio);

        puntaje.setText(String.valueOf(punto0));
        //Caso de reiniciar
        etNombre.setText(String.valueOf(nombre0));
    }

    public void empezar (View view){
        if(etNombre.getText().toString().length()!=0) {
            Intent i = new Intent(this, Nivel0.class);
            i.putExtra("nombre", etNombre.getText().toString());
            i.putExtra("puntaje", puntaje.getText().toString());
            startActivity(i);
        }else{
            tvMsg.setText("Tenés que escribir tu nombre para jugar!:P");
        }
    }
}