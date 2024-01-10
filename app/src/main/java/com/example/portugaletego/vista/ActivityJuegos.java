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
        setContentView(R.layout.activity_juegos);

        int id = getIntent().getIntExtra("id", 0);

        System.out.println(id);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentJuego1);

        //Tendremos que meterlo dentro de un intent al seleccionar el pulsador en el mapa
       if(id == 1) {
           Fragment nuevoFragment = new FragmentJuego1();
           fragmentTransaction.replace(R.id.fragmentJuego1, nuevoFragment);
       }
       else if(id == 2){
          // Fragment nuevoFragment = new FragmentJuego2();
          // fragmentTransaction.replace(R.id.fragmentJuego, nuevoFragment);
       }
       else if(id == 3){
           // Fragment nuevoFragment = new FragmentJuego3();
           // fragmentTransaction.replace(R.id.fragmentJuego, nuevoFragment);
       }
       else if(id == 2){
           // Fragment nuevoFragment = new FragmentJuego4();
           // fragmentTransaction.replace(R.id.fragmentJuego, nuevoFragment);
       }
       else if(id == 2){
           // Fragment nuevoFragment = new FragmentJuego5();
           // fragmentTransaction.replace(R.id.fragmentJuego, nuevoFragment);
       }
        fragmentTransaction.commit();
    }
}