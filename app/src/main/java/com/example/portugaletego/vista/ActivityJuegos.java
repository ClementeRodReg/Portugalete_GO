package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.portugaletego.R;

public class ActivityJuegos extends AppCompatActivity {

    Button btnVolver, btnSiguiente;
    ImageButton btnMute, btnUnmute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        btnVolver = findViewById(R.id.btnvolver);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnMute = findViewById(R.id.btnMute);
        btnUnmute = findViewById(R.id.btnUnmute);

        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mutear(amanager);
            }
        });

        btnUnmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unmute(amanager);
            }
        });

        int id = getIntent().getIntExtra("id", 0);

        System.out.println(id);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentJuegos);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        //Tendremos que meterlo dentro de un intent al seleccionar el pulsador en el mapa
       if(id == 1) {
           Fragment nuevoFragment = new FragmentJuego1();
           fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
       }
       else if(id == 2){
           Fragment nuevoFragment = new FragmentJuego2();
           fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
       }
       else if(id == 3){
           Fragment nuevoFragment = new fragmentCamara();
           nuevoFragment.setArguments(bundle);
           fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
       }
       else if(id == 4){
           Fragment nuevoFragment = new fragmentCamara();
           nuevoFragment.setArguments(bundle);
           fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
       }
        fragmentTransaction.commit();
    }


    public void volver(){
        Intent mandar = new Intent(this, VistaMapa.class);
        startActivity(mandar);
    }

    public void mutear(AudioManager amanager){

        amanager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
        btnMute.setVisibility(View.INVISIBLE);
        btnUnmute.setVisibility(View.VISIBLE);
    }

    public void unmute(AudioManager amanager){

        amanager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
        btnUnmute.setVisibility(View.INVISIBLE);
        btnMute.setVisibility(View.VISIBLE);
    }

}