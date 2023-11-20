package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.ControladorPasarVentana;

public class MainActivity extends AppCompatActivity {
    Intent mandar;
    final Handler handler = new Handler();
    final int delay = 500;
    int insertado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControladorPasarVentana pasarVentana = new ControladorPasarVentana(MainActivity.this, VistaMapa.class);

        handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    mandar = pasarVentana.getMandar();
                    startActivity(mandar);
                } catch (Exception ex) {
                }

                if (insertado < 1)
                    handler.postDelayed(this, delay);
            }
        }, delay);


    }
}