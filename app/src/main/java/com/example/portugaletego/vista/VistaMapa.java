package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import com.example.portugaletego.R;

public class VistaMapa extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vista_mapa);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverLogin();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentCV);
        Fragment nuevoFragment1 = new MapFragment();
/*
        Fragment fragment2 = fragmentManager.findFragmentById(R.id.fcvCamara);
        Fragment nuevoFragment2 = new fragmentCamara();

        Bundle datos = new Bundle();
        datos.putString("nombre carpeta", "r_g3");
        datos.putString("ejer", "ejer3");
        nuevoFragment2.setArguments(datos);

        fragmentTransaction.replace(R.id.fcvCamara, nuevoFragment2);
*/
        fragmentTransaction.replace(R.id.fragmentCV, nuevoFragment1);

        fragmentTransaction.commit();

    }

    public void mandar(int id){
        Intent mandar = new Intent(this, ActivityJuegos.class);
        mandar.putExtra("id",id); //revisar con clemen, mandamos un id segun el pulsador que utilicemos
        startActivity(mandar);
    }

    public void volverLogin(){
        Intent volver = new Intent(this, LoginActivity.class);
        startActivity(volver);
    }
}