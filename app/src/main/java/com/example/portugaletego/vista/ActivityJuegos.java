package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.portugaletego.R;

public class ActivityJuegos extends AppCompatActivity {
    MediaPlayer mp;
    Button btnVolver, btnSiguiente;
    ImageButton btnMute, btnUnmute;
    Fragment fragment, nuevoFragment, fragmentActual;
    FragmentTransaction fragmentTransaction;
    Fragment f2 = new FragmentJuego2();
    Fragment f1 = new FragmentJuego1();
    int contadorSaltos = 0;
    int idGrupo;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        btnVolver = findViewById(R.id.btnvolver);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnMute = findViewById(R.id.btnMute);
        btnUnmute = findViewById(R.id.btnUnmute);

        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Obtenemos el ID del juego que queremos poner
        id = getIntent().getIntExtra("id", 0);
        idGrupo = getIntent().getIntExtra("idGrupo", 0);
        System.out.println(id);
        System.out.println(idGrupo);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragment = fragmentManager.findFragmentById(R.id.fragmentJuegos);

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        //Ejecutamos el cambio de fragment
        fragmentActual = cambioFragment(id, fragmentTransaction, bundle);

        //este contador solo se aplica para los juegos que tienen algun tipo de enunciado
        //cada vez que entremos aqui, se pondra a 0
        contadorSaltos = 0;

        System.out.println(fragmentActual.getClass());
        // int num = detectarFragment(fragmentActual);


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(mp);
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

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente(fragmentActual, id, bundle, fragmentManager);
            }
        });
    }

    private void siguiente(Fragment fragmentActual, int id, Bundle bundle, FragmentManager fragmentManager) {

        switch (id) {
            case 0:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentJuegos, f1);
                fragmentTransaction.commit();
                btnSiguiente.setVisibility(View.INVISIBLE);
                break;
            case 1:
                FragmentTransaction fReal = fragmentManager.beginTransaction();
                fReal.replace(R.id.fragmentJuegos, f2);
                fReal.commit();
                btnSiguiente.setVisibility(View.INVISIBLE);
                break;
            case 2:
                switch (contadorSaltos) {
                    case 0:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 1);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 1:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 2:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 2);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 3:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 4:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 3);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 5:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 6:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 4);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 7:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 8:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 5);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        btnSiguiente.setVisibility(View.INVISIBLE);
                        break;
                }
                break;
            case 3:
                switch (contadorSaltos) {
                    case 0:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 1);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 1:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 2:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 2);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        System.out.println(contadorSaltos);
                        break;
                    case 3:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 4:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 3);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 5:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 6:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 4);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 7:
                        nuevoFragment = new Fragment_Enunciado();
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        contadorSaltos++;
                        break;
                    case 8:
                        nuevoFragment = new fragmentCamara();
                        bundle.putInt("parte", 5);
                        nuevoFragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                        fragmentTransaction.commit();
                        btnSiguiente.setVisibility(View.INVISIBLE);
                        contadorSaltos++;
                        break;
                }


        }

    }


    //Vuelve al mapa, y si hay un audio en reproduccion, lo libera
    public void volver(MediaPlayer mp) {
        Intent mandar = new Intent(this, VistaMapa.class);
        mandar.putExtra("idGrupo", idGrupo);
        startActivity(mandar);
        if (mp != null) {
            mp.release();
        }
    }

    //silencia el audio
    public void mutear(AudioManager amanager) {

        amanager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
        btnMute.setVisibility(View.GONE);
        btnUnmute.setVisibility(View.VISIBLE);
    }

    //vuelve el sonido al audio
    public void unmute(AudioManager amanager) {

        amanager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
        btnUnmute.setVisibility(View.GONE);
        btnMute.setVisibility(View.VISIBLE);
    }

    //Metodo para cambiar el fragment que viene por defecto al correspondiente segun como accedamos por el mapa
    //int id = mandamos por un codigo numero
    public Fragment cambioFragment(int id, FragmentTransaction fragmentTransaction, Bundle bundle) {
        switch (id) {
            case 0: //vamos al juego 1
                nuevoFragment = new Fragment_Enunciado();
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                btnSiguiente.setVisibility(View.VISIBLE);
                mp = MediaPlayer.create(this, R.raw.explicacion_puente_colgante);
                mp.start();
                break;
            case 1: //vamos al juego 2
                nuevoFragment = new Fragment_Enunciado();
                bundle.putInt("idGrupo", idGrupo);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                btnSiguiente.setVisibility(View.VISIBLE);
                mp = MediaPlayer.create(this, R.raw.rialia_eta_nikolas_deuna);
                mp.start();
                break;
            case 2: //vamos al primer fragment con camara
                bundle.putInt("idGrupo", idGrupo);
                //previo a la camara hay que activar un fragment de texto
                nuevoFragment = new Fragment_Enunciado();
                btnSiguiente.setVisibility(View.VISIBLE);
                //nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
            case 3: //vamos al segundo fragment con camara
                bundle.putInt("idGrupo", idGrupo);
                nuevoFragment = new Fragment_Enunciado();
                btnSiguiente.setVisibility(View.VISIBLE);
                //nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
        }
        fragmentTransaction.commit(); // -> Realiza el cambio
        return nuevoFragment;
    }

    public MediaPlayer getMp() {
        return mp;
    }

    public int getId() {
        return id;
    }

    public int getIdGrupo(){
        return idGrupo;
    }

    public int getContadorSaltos() {
        return contadorSaltos;
    }
}




