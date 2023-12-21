package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.portugaletego.R;

public class ActivityJuegos extends AppCompatActivity {

    Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();
        int id = bundle.getInt("id");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentJuego);
        Fragment nuevoFragment = new MapFragment();


        //Tendremos que meterlo dentro de un intent al seleccionar el pulsador en el mapa
       if(id == 1) {
           fragmentTransaction.replace(R.id.fragmentJuego, nuevoFragment);
           fragmentTransaction.commit();
       }
    }
}