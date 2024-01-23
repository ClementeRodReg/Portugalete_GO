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

import com.example.portugaletego.modelo.Usuario;
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

    SharedPreferences sharedpreferences;
    private FirebaseAuth mAuth;
    CardView card1 , card2;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        Bundle bundle =  getIntent().getExtras();
        int num = bundle.getInt("num");

        if(num == 2){
            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.GONE);
        }else{
            card2.setVisibility(View.VISIBLE);
            card1.setVisibility(View.GONE);
        }



        //sharedPreferences crear
        Context context = LoginActivity.this;

        mAuth = FirebaseAuth.getInstance();
        //sharedPreferences leer
        String defaultUser = "";


        //declaramos auth con firebase.getInstance
        // mAuth = FirebaseAuth.getInstance();

        //valores
        EditText contrasenna = (EditText) findViewById(R.id.editTextContrasenna);
        Button confirmar = (Button) findViewById(R.id.buttonConfirmar);
        EditText txtUsuario = (EditText) findViewById(R.id.TextImputNombre);
        Button mapa = (Button) findViewById(R.id.Map);

        //valores para la seleccion de alumnos
        spinner = findViewById(R.id.spinner);

        ArrayList<Usuario> opciones = new ArrayList<Usuario>();
        //añadimos 3 clases provisionales para añadir luego a room

        opciones.add(new Usuario(1,"Grupo 1"));
        opciones.add(new Usuario(2, "Grupo 2"));
        opciones.add(new Usuario(3, "Grupo 3"));

        //creamos el adaptador para el spinner
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spinner.setAdapter(adapter);



        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambio = new Intent(LoginActivity.this, VistaMapa.class);
                cambio.putExtra("num",num);
                startActivity(cambio);
            }
        });

        //Iniciar sesion
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtUsuario.getText().toString();
                String password = contrasenna.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                    builder.setTitle("Login");

                    builder.setPositiveButton("Aceptar", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // boton de aceptar y cerrar pop-up
                        dialog.cancel();
                    });

                    builder.setMessage("Usuario o contraseña vacios");
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    return;
                } else {

                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        //intent
                                        Intent cambio = new Intent(LoginActivity.this, VistaProfesor.class);
                                        startActivity(cambio);

                                    } else {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        builder.setTitle("Login");
                                        builder.setPositiveButton("Aceptar", (DialogInterface.OnClickListener) (dialog, which) -> {
                                            // boton de aceptar y cerrar pop-up
                                            dialog.cancel();
                                        });

                                        builder.setMessage("Usuario o contraseña incorrecta");
                                        AlertDialog dialog = builder.create();
                                        dialog.show();

                                    }
                                }
                            });

                }
            }

        });
    }


    private void setup() {

    }
}