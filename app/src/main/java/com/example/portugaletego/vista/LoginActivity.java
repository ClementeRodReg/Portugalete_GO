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

import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.modelo.Grupo;
import com.example.portugaletego.modelo.Puntuacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import com.example.portugaletego.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    List<Grupo> gruposRoom;

    BBDD appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //valores
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        password = findViewById(R.id.editTextContrasenna);
        confirmar = findViewById(R.id.buttonConfirmar);
        txtUsuario = findViewById(R.id.TextImputNombre);
        mapa = findViewById(R.id.Map);
        spinner = findViewById(R.id.spinner);
        volver = findViewById(R.id.volveraInicio);
        accederEstudiante = findViewById(R.id.AccesoMapasEstudiante);


        appDatabase = BBDD.getDatabase(getApplicationContext()); //obtenemos la base de datos

        //Recoge el numero del Activity anterior, si es 1, mostrara la tarjeta de login del profesor
        //Si es un 2, la de seleccion de grupo para alumnos
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

        //recogemos los grupos disponibles  <!!!!!!!>
        gruposRoom = appDatabase.daoGrupo().obtenerGrupos();

        //sharedPreferences crear
        Context context = LoginActivity.this;

        mAuth = FirebaseAuth.getInstance();
        //sharedPreferences leer
        String defaultUser = "";

        //creamos el adaptador para el spinner
        ArrayAdapter<Grupo> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, gruposRoom);
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

    //CAMBIAMOS DE ACTIVITY EN FUNCION DE LA ELECCION
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
                try {
                    appDatabase.daoPuntuacion().insertarPuntuacion(new Puntuacion(spinner.getSelectedItem().toString() + obtenerFechaActual(), 0));
                }catch(Exception ex){}
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

    public String obtenerFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }
}