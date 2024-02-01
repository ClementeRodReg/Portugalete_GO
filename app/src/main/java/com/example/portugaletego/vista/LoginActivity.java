package com.example.portugaletego.vista;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.portugaletego.modelo.Grupo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import com.example.portugaletego.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    // private FirebaseAuth mAuth;

    //Variables de uso comun
    String email, pass;
    ArrayList<Grupo> grupos;
    Intent cambio;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    SharedPreferences sharedpreferences;
    private FirebaseAuth mAuth;
    CardView card1 , card2;
    Spinner spinner;
    EditText txtUsuario, password;
    Button volver, mapa, confirmar, accederEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        Bundle bundle =  getIntent().getExtras();
        if(bundle != null){
            if(bundle.containsKey("num")){
                int num = bundle.getInt("num");
                if(num == 2){
                    card1.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.GONE);
                }else{
                    card2.setVisibility(View.VISIBLE);
                    card1.setVisibility(View.GONE);
                }
            }
        }

        //sharedPreferences crear
        Context context = LoginActivity.this;

        mAuth = FirebaseAuth.getInstance();
        //sharedPreferences leer
        String defaultUser = "";


        //declaramos auth con firebase.getInstance
        // mAuth = FirebaseAuth.getInstance();

        //valores
        password = findViewById(R.id.editTextContrasenna);
        confirmar = findViewById(R.id.buttonConfirmar);
        txtUsuario = findViewById(R.id.TextImputNombre);
        mapa = findViewById(R.id.Map);
        spinner = findViewById(R.id.spinner);
        volver = findViewById(R.id.volveraInicio);
        accederEstudiante = findViewById(R.id.AccesoMapasEstudiante);

        //rellenamos el array
        grupos = RellenarArray();

        //creamos el adaptador para el spinner
        ArrayAdapter<Grupo> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, grupos);
        spinner.setAdapter(adapter);

        //BOTON PARA IR AL MAPA
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambio(0);
            }
        });

        //BOTON PARA VOLVER AL INICIO
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambio(3);
            }
        });

        //Iniciar sesion COMO PROFESOR
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtUsuario.getText().toString();
                pass = password.getText().toString();
                if (email.isEmpty() || pass.isEmpty()) {
                    MostrarAlertDialog(0);
                } else {
                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        //intent opcion 1 -> Profesor
                                        cambio(1);
                                    } else {
                                        MostrarAlertDialog(1);
                                    }
                                }
                            });

                }
            }

        });

        accederEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambio(2);
            }
        });
    }


    private void cambio(int check) {
        switch(check){
            //acceso simple al mapa
            case 0: cambio = new Intent(LoginActivity.this, VistaMapa.class);
                startActivity(cambio);
                break;

            //acceso como profesor
            case 1: cambio = new Intent(LoginActivity.this, VistaProfesor.class);
                startActivity(cambio);
                break;
            //Acceso como alumnado, depende del grupo que escojas, mandara un id u otro
            case 2: cambio = new Intent(LoginActivity.this, VistaMapa.class);
                cambio.putExtra("idGrupo",spinner.getSelectedItemPosition());
                System.out.println(spinner.getSelectedItemPosition());
                startActivity(cambio);
                break;
            //Vuelta a la seleccion de clase
            case 3: cambio = new Intent(LoginActivity.this, ActivitySeleccion
                    .class);
                startActivity(cambio);
                break;
        }
    }

    private ArrayList<Grupo> RellenarArray(){
        ArrayList<Grupo> opciones = new ArrayList<Grupo>();
        //Añadimos 3 clases provisionales para añadir luego a room (TO DO)

        opciones.add(new Grupo(1,"Grupo 1"));
        opciones.add(new Grupo(2, "Grupo 2"));
        opciones.add(new Grupo(3, "Grupo 3"));

        return opciones;
    }

    private void MostrarAlertDialog(int check){
        switch(check){
            case 0:builder = new AlertDialog.Builder(LoginActivity.this);

                builder.setTitle("Login");

                builder.setPositiveButton("Aceptar", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // boton de aceptar y cerrar pop-up
                    dialog.cancel();
                });

                builder.setMessage("Usuario o contraseña vacios");
                dialog = builder.create();
                dialog.show();
            case 1:
                builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Login");
                builder.setPositiveButton("Aceptar", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // boton de aceptar y cerrar pop-up
                    dialog.cancel();
                });

                builder.setMessage("Usuario o contraseña incorrecta");
                dialog = builder.create();
                dialog.show();
        }
    }
}