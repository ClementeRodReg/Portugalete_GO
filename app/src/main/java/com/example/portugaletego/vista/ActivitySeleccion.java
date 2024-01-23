package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.portugaletego.R;

public class ActivitySeleccion extends AppCompatActivity {

    Button btnProfe, btnAlumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        btnProfe = findViewById(R.id.btnProfesor);
        btnAlumno = findViewById(R.id.btnAlumno);

        btnAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambio(1);
            }
        });

        btnProfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambio(2);
            }
        });
    }

    public void cambio(int num){
        Intent intent = new Intent(this,LoginActivity.class);
        intent.putExtra("num", num);

        startActivity(intent);

    }
}