package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.ControladorPasarVentana;

public class ventanaJuego1BizkaikoZubia extends AppCompatActivity {

    Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_juego1_bizkaiko_zubia);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (ventanaJuego1BizkaikoZubia.this, VistaMapa.class);
                startActivity(i);
            }
        });
    }
}