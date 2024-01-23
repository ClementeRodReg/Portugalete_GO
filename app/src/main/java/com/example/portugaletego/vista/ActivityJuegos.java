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

    int contadorSaltos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        btnVolver = findViewById(R.id.btnvolver);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnMute = findViewById(R.id.btnMute);
        btnUnmute = findViewById(R.id.btnUnmute);

        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int id = getIntent().getIntExtra("id", 0);

        System.out.println(id);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragment = fragmentManager.findFragmentById(R.id.fragmentJuegos);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        //Ejecutamos el cambio de fragment
        fragmentActual = cambioFragment(id,fragmentTransaction,bundle);

        System.out.println(fragmentActual.getClass());
        // int num = detectarFragment(fragmentActual);


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

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // siguiente(num,bundle, fragmentTransaction);
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

    private void siguiente(Fragment fragmentActual, int id ,Bundle bundle, FragmentTransaction fragmentTransaction) {
        if(fragmentActual.getClass().equals(Fragment_Enunciado.class)){
            switch (id){
                case 3:
                    if(contadorSaltos % 2 == 0 ){

                    }else{

                    }
                    break;
                case 4:
                    if(contadorSaltos % 2 == 0 ){

                    }else{

                    }
                    break;
            }
        }
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

    public void onDestroy(){

       super.onDestroy();
        if (mp.isPlaying()) { mp.stop(); mp.release();
            //finally
        }
    }

    //Metodo para cambiar el fragment que viene por defecto al correspondiente segun como accedamos por el mapa
    //int id = mandamos por un codigo numero
    public Fragment cambioFragment(int id,FragmentTransaction fragmentTransaction, Bundle bundle){
        switch(id) {
            case 1: //vamos al juego 1
                nuevoFragment = new FragmentJuego1();
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);

                mp = MediaPlayer.create(this, R.raw.explicacion_puente_colgante);
                mp.start();
                break;
            case 2: //vamos al juego 2
                nuevoFragment = new FragmentJuego2();
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);

                mp = MediaPlayer.create(this, R.raw.rialia_eta_nikolas_deuna);
                mp.start();
                break;
            case 3: //vamos al primer fragment con camara

                //previo a la camara hay que activar un fragment de texto
                //nuevoFragment = new fragmentCamara();

                nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
            case 4: //vamos al segundo fragment con camara
                //nuevoFragment = new fragmentCamara();

                nuevoFragment = new Fragment_Enunciado();
                nuevoFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentJuegos, nuevoFragment);
                break;
        }
            fragmentTransaction.commit(); // -> Realiza el cambio
            return nuevoFragment;
        }


    }




