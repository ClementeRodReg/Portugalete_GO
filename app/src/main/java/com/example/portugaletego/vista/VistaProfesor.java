package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.portugaletego.R;

public class VistaProfesor extends AppCompatActivity {

    FragmentContainerView layoutRespuestas;
    Button g1;
    Button g2;
    Button g3;
    Button btnLogin, btnRanking, btnGrupos;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_profesor);

        layoutRespuestas = findViewById(R.id.fragmentRespuestasGrupos);
        g1 = findViewById(R.id.g1Button);
        g2 = findViewById(R.id.g2Button);
        g3 = findViewById(R.id.g3Button);

        btnLogin = findViewById(R.id.btnLoginProf);
        btnRanking = findViewById(R.id.btnRanking);
        btnGrupos = findViewById(R.id.btnGrupos);
        linearLayout = findViewById(R.id.layoutBotonesProfesor);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
        Fragment nuevoFragment1 = new RespuestaGrupos();

        Bundle datos = new Bundle();
        datos.putString("nombre carpeta", "r_g1");
        nuevoFragment1.setArguments(datos);

        fragmentTransaction.replace(R.id.fragmentRespuestasGrupos, nuevoFragment1);
        fragmentTransaction.commit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverLogin();
            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGrupos.setVisibility(View.VISIBLE);
                btnRanking.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //    Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
                Fragment nuevoFragment1 = new FragmentRanking();


                fragmentTransaction.replace(R.id.fragmentRespuestasGrupos, nuevoFragment1);
                fragmentTransaction.commit();
            }
        });

        btnGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGrupos.setVisibility(View.GONE);
                btnRanking.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

              //  Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
                Fragment nuevoFragment1 = new RespuestaGrupos();

                Bundle datos = new Bundle();
                datos.putString("nombre carpeta", "r_g1");
                nuevoFragment1.setArguments(datos);

                fragmentTransaction.replace(R.id.fragment_ranking, nuevoFragment1);
                fragmentTransaction.commit();

            }
        });

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutRespuestas.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
                Fragment nuevoFragment1 = new RespuestaGrupos();

                Bundle datos = new Bundle();
                datos.putString("nombre carpeta", "r_g1");
                nuevoFragment1.setArguments(datos);

                fragmentTransaction.replace(R.id.fragmentRespuestasGrupos, nuevoFragment1);
                fragmentTransaction.commit();
            }
        });

        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutRespuestas.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
                Fragment nuevoFragment1 = new RespuestaGrupos();

                Bundle datos = new Bundle();
                datos.putString("nombre carpeta", "r_g2");
                nuevoFragment1.setArguments(datos);

                fragmentTransaction.replace(R.id.fragmentRespuestasGrupos, nuevoFragment1);
                fragmentTransaction.commit();
            }
        });

        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutRespuestas.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

               // Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragmentRespuestasGrupos);
                Fragment nuevoFragment1 = new RespuestaGrupos();

                Bundle datos = new Bundle();
                datos.putString("nombre carpeta", "r_g3");
                nuevoFragment1.setArguments(datos);

                fragmentTransaction.replace(R.id.fragmentRespuestasGrupos, nuevoFragment1);
                fragmentTransaction.commit();
            }
        });
    }

    public void volverLogin() {
        Intent volver = new Intent(this, LoginActivity.class);
        startActivity(volver);
    }
}