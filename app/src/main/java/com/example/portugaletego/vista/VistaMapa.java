package com.example.portugaletego.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.portugaletego.R;

public class VistaMapa extends AppCompatActivity {

    Button btnLogin;
    TextView nombreGrupo;
    int idGrupo=0;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vista_mapa);

        btnLogin = findViewById(R.id.btnLoginProf);
        nombreGrupo = findViewById(R.id.nombreGrupo);

        Bundle bundle =  getIntent().getExtras();
        if(bundle != null){
            if(bundle.containsKey("idGrupo")){
                idGrupo = bundle.getInt("idGrupo");
                switch(idGrupo){
                    case 0: nombreGrupo.setText("G1"); break;
                    case 1: nombreGrupo.setText("G2"); break;
                    case 2: nombreGrupo.setText("G3"); break;
                }
                nombreGrupo.setVisibility(View.VISIBLE);
            }
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverInicio();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragment = fragmentManager.findFragmentById(R.id.fragmentCV);
        Fragment nuevoFragment1 = new MapFragment();

        fragmentTransaction.replace(R.id.fragmentCV, nuevoFragment1);

        fragmentTransaction.commit();

    }

    public void mandar(int id){
        Intent mandar = new Intent(this, ActivityJuegos.class);
        mandar.putExtra("id",id); //revisar con clemen, mandamos un id segun el pulsador que utilicemos
        mandar.putExtra("grupo",idGrupo);
        startActivity(mandar);
    }

    public void volverInicio(){
        Intent volver = new Intent(this, ActivitySeleccion.class);
        startActivity(volver);
    }
}