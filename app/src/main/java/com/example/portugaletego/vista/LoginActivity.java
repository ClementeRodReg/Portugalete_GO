package com.example.portugaletego.vista;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import com.example.portugaletego.R;

public class LoginActivity extends AppCompatActivity {

    // private FirebaseAuth mAuth;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //sharedPreferences crear
        Context context = LoginActivity.this;
        sharedpreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);

        //sharedPreferences leer
        String defaultUser = "";
        String rememberUser = sharedpreferences.getString("", defaultUser);

        //declaramos auth con firebase.getInstance
        // mAuth = FirebaseAuth.getInstance();

        //valores
        EditText contrasenna = (EditText) findViewById(R.id.editTextContrasenna);
        Button confirmar = (Button) findViewById(R.id.buttonConfirmar);
        EditText txtUsuario = (EditText) findViewById(R.id.TextImputNombre);
        txtUsuario.setText(rememberUser);
        Button mapa = (Button) findViewById(R.id.Map);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cambio = new Intent(LoginActivity.this, VistaMapa.class);
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
                }

/*
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    //intent

                                    Intent cambio = new Intent(LoginActivity.this, MainActivity2.class);
                                    String usuario = email;
                                    cambio.putExtra("usuario", usuario);
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

                //sharedPreferences escribir
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("", email);
                editor.apply();
                */

            }


        });
    }


    private void setup() {

    }
}