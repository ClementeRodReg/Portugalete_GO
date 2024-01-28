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

    boolean fragEnunciadoON = true;

    Fragment fragmento_enunciado = new Fragment_Enunciado();
    Fragment fragCam = new fragmentCamara();

    Fragment f2 = new FragmentJuego2();

    int contadorSaltos = 0;
    int grupo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        btnVolver = findViewById(R.id.btnvolver);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnMute = findViewById(R.id.btnMute);
        btnUnmute = findViewById(R.id.btnUnmute);

        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int id = getIntent().getIntExtra("id", 0);
        grupo = getIntent().getIntExtra("grupo", 0);
        System.out.println(id);

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

  /*  private int detectarFragment(Fragment fragmentActual){
        // REVISAR MAÑANA SIN FALTA -> NO DEBERIA FUNCIONAR -> HE ASIGNADO UN ID EN EL LINEAR LAYOUT CON ESTE NOMBRE MIENTRAS QUE EL RESTO NO LO NECESITA
        int numbero = 0;
        if(fragmentActual == null || fragmentActual.getClass().equals(findViewById(R.id.fragment_enunciados))){
            numbero = 1;
        }
        return numbero;
    }

   */

    private void siguiente(Fragment fragmentActual, int id, Bundle bundle, FragmentManager fragmentManager) {
        switch (id) {
            case 2:
               FragmentTransaction fReal = fragmentManager.beginTransaction();
               fReal.replace(R.id.fragmentJuegos, f2);
               fReal.commit();
               btnSiguiente.setVisibility(View.INVISIBLE);
               break;


                case 3:
                    switch (contadorSaltos){
                        case 0:
                            nuevoFragment = new fragmentCamara();
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
                            btnSiguiente.setVisibility(View.INVISIBLE);
                            break;
                    }
                    break;
                case 4:
                /*    FragmentTransaction fReal3 = fragmentManager.beginTransaction();
                    fReal3.replace(R.id.fragmentJuegos, fragCam);
                    fReal3.commit();
                    btnSiguiente.setVisibility(View.INVISIBLE);
                    break;
                    */

        }

    }


    //Vuelve al mapa, y si hay un audio en reproduccion, lo libera
    public void volver(MediaPlayer mp) {
        Intent mandar = new Intent(this, VistaMapa.class);
        mandar.putExtra("idGrupo", grupo);
        startActivity(mandar);
        if (mp != null) {
            mp.release();
        }
    }

    //silencia el audio
    public void mutear(AudioManager amanager) {

        amanager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
        btnMute.setVisibility(View.INVISIBLE);
        btnUnmute.setVisibility(View.VISIBLE);
    }

    //vuelve el sonido al audio
    public void unmute(AudioManager amanager) {

        amanager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
        btnUnmute.setVisibility(View.INVISIBLE);
        btnMute.setVisibility(View.VISIBLE);
    }

    //Metodo para cambiar el fragment que viene por defecto al correspondiente segun como accedamos por el mapa
    //int id = mandamos por un codigo numero
    public Fragment cambioFragment(int id, FragmentTransaction fragmentTransaction, Bundle bundle) {
        switch (id) {
            case 1: //vamos al juego 1
                nuevoFragment = new FragmentJuego1();
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);

                mp = MediaPlayer.create(this, R.raw.explicacion_puente_colgante);
                mp.start();
                break;
            case 2: //vamos al juego 2
                nuevoFragment = new Fragment_Enunciado();
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                btnSiguiente.setVisibility(View.VISIBLE);
                mp = MediaPlayer.create(this, R.raw.rialia_eta_nikolas_deuna);
                mp.start();
                break;
            case 3: //vamos al primer fragment con camara
                bundle.putInt("grupo", grupo);
                //previo a la camara hay que activar un fragment de texto
                nuevoFragment = new Fragment_Enunciado();
                btnSiguiente.setVisibility(View.VISIBLE);
                //nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
            case 4: //vamos al segundo fragment con camara
                bundle.putInt("grupo", grupo);
                nuevoFragment = new fragmentCamara();
                btnSiguiente.setVisibility(View.VISIBLE);
                //nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
        }
        fragmentTransaction.commit(); // -> Realiza el cambio
        return nuevoFragment;
    }

    public MediaPlayer getMp(){
        return mp;
    }
}




