package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.portugaletego.R;
import com.example.portugaletego.controlador.ControladorPasarVentana;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    Intent mandar;
    final Handler handler = new Handler();
    final int delay = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControladorPasarVentana pasarVentana = new ControladorPasarVentana(MainActivity.this, LoginActivity.class);

        handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    mandar = pasarVentana.getMandar();
                    startActivity(mandar);

                } catch (Exception ex) {
                }
                if (pasarVentana.getContador() < 1)
                    handler.postDelayed(this, delay);

            }
        }, delay);

    }
}