package com.example.portugaletego.vista;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portugaletego.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StreamDownloadTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RespuestaGrupos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RespuestaGrupos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombre carpeta";

    // TODO: Rename and change types of parameters
    private String grupo;
    private TextView ngrupo;
    private FirebaseAuth mAuth;
    LinearLayout layoutGrande;
    FirebaseStorage storage;
    StorageReference storageRef;

    public RespuestaGrupos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RespuestaGrupos.
     */
    // TODO: Rename and change types and number of parameters
    public static RespuestaGrupos newInstance(String param1) {
        RespuestaGrupos fragment = new RespuestaGrupos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            grupo = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_respuesta_grupos, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        ngrupo = view.findViewById(R.id.textvG1);

        LinearLayout ll1 = view.findViewById(R.id.layoutg1);
        LinearLayout ll41 = view.findViewById(R.id.layoutejer4parte1);
        LinearLayout ll42 = view.findViewById(R.id.layoutejer4parte2);
        LinearLayout ll43 = view.findViewById(R.id.layoutejer4parte3);
        LinearLayout ll44 = view.findViewById(R.id.layoutejer4parte4);
        LinearLayout ll45 = view.findViewById(R.id.layoutejer4parte5);
        if (grupo != null) {

            if (grupo.equals("r_g1"))
                ngrupo.setText("GRUPO 1");
            else if (grupo.equals("r_g2"))
                ngrupo.setText("GRUPO 2");
            else
                ngrupo.setText("GRUPO 3");
        } else {
            grupo = "nada";
        }

        if (grupo.equals("r_g1")) {

            ImageView ejerfoto1 = view.findViewById(R.id.fotoSacada1);
            ImageView ejerfoto2 = view.findViewById(R.id.fotoSacada2);
            ImageView ejerfoto3 = view.findViewById(R.id.fotoSacada3);
            ImageView ejerfoto4 = view.findViewById(R.id.fotoSacada4);
            ImageView ejerfoto5 = view.findViewById(R.id.fotoSacada5);
            File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());

            String nombreFoto1 = grupo+"RespuestaEjer4parte1";
            String nombreFoto2 = grupo+"RespuestaEjer4parte2";
            String nombreFoto3 = grupo+"RespuestaEjer4parte3";
            String nombreFoto4 = grupo+"RespuestaEjer4parte4";
            String nombreFoto5 = grupo+"RespuestaEjer4parte5";

            File[] files = path.listFiles();

            for (int o = 0; o < files.length; o++) {
                if (files[o].isDirectory()) {
                    File Dir = new File(files[o].getAbsolutePath());
                    File[] filesInDir = Dir.listFiles();
                    for (int num = 0; num < filesInDir.length; num++) {
                        if (filesInDir[num].getName().contains(nombreFoto1)) {
                            try {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    byte[] bytes = Files.readAllBytes(Paths.get(filesInDir[num].getAbsolutePath()));
                                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                                            .decodeByteArray(bytes, 0, bytes.length);
                                    ejerfoto1.setImageBitmap(bitmapimg);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (filesInDir[num].getName().contains(nombreFoto2)) {
                            try {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    byte[] bytes = Files.readAllBytes(Paths.get(filesInDir[num].getAbsolutePath()));
                                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                                            .decodeByteArray(bytes, 0, bytes.length);
                                    ejerfoto2.setImageBitmap(bitmapimg);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (filesInDir[num].getName().contains(nombreFoto3)) {
                            try {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    byte[] bytes = Files.readAllBytes(Paths.get(filesInDir[num].getAbsolutePath()));
                                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                                            .decodeByteArray(bytes, 0, bytes.length);
                                    ejerfoto3.setImageBitmap(bitmapimg);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (filesInDir[num].getName().contains(nombreFoto4)) {
                            try {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    byte[] bytes = Files.readAllBytes(Paths.get(filesInDir[num].getAbsolutePath()));
                                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                                            .decodeByteArray(bytes, 0, bytes.length);
                                    ejerfoto4.setImageBitmap(bitmapimg);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (filesInDir[num].getName().contains(nombreFoto5)) {
                            try {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    byte[] bytes = Files.readAllBytes(Paths.get(filesInDir[num].getAbsolutePath()));
                                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                                            .decodeByteArray(bytes, 0, bytes.length);
                                    ejerfoto5.setImageBitmap(bitmapimg);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                }
            }

            TextView descejer1 = view.findViewById(R.id.desc1);
            descejer1.setText("ejercicio 4 parte 1");
            TextView descejer2 = view.findViewById(R.id.desc2);
            descejer2.setText("ejercicio 4 parte 2");
            TextView descejer3 = view.findViewById(R.id.desc3);
            descejer3.setText("ejercicio 4 parte 3");
            TextView descejer4 = view.findViewById(R.id.desc4);
            descejer4.setText("ejercicio 4 parte 4");
            TextView descejer5 = view.findViewById(R.id.desc5);
            descejer5.setText("ejercicio 4 parte 5");

            Button aprobar1 = view.findViewById(R.id.Aprobarbtn1);
            Button aprobar2 = view.findViewById(R.id.Aprobarbtn2);
            Button aprobar3 = view.findViewById(R.id.Aprobarbtn3);
            Button aprobar4 = view.findViewById(R.id.Aprobarbtn4);
            Button aprobar5 = view.findViewById(R.id.Aprobarbtn5);
            aprobar1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoA(1);
                    ll41.setVisibility(View.GONE);
                }
            });
            aprobar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoA(2);
                    ll42.setVisibility(View.GONE);
                }
            });
            aprobar3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoA(3);
                    ll43.setVisibility(View.GONE);
                }
            });
            aprobar4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoA(4);
                    ll44.setVisibility(View.GONE);
                }
            });
            aprobar5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoA(5);
                    ll45.setVisibility(View.GONE);
                }
            });

            Button pencar1 = view.findViewById(R.id.Pencarbtn1);
            Button pencar2 = view.findViewById(R.id.Pencarbtn2);
            Button pencar3 = view.findViewById(R.id.Pencarbtn3);
            Button pencar4 = view.findViewById(R.id.Pencarbtn4);
            Button pencar5 = view.findViewById(R.id.Pencarbtn5);
            pencar1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoP(1);
                    ll41.setVisibility(View.GONE);
                }
            });
            pencar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoP(2);
                    ll42.setVisibility(View.GONE);
                }
            });
            pencar3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoP(3);
                    ll43.setVisibility(View.GONE);
                }
            });
            pencar4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoP(4);
                    ll44.setVisibility(View.GONE);
                }
            });
            pencar5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avisoP(5);
                    ll45.setVisibility(View.GONE);
                }
            });

        }
    }

    public void avisoA(int parte) {
        Toast.makeText(getView().getContext(), ngrupo.getText() + " ha aprobado el ejercicio 4 parte " + parte, Toast.LENGTH_SHORT).show();
    }

    public void avisoP(int parte) {
        Toast.makeText(getView().getContext(), ngrupo.getText() + " ha pencado el ejercicio 4 parte " + parte, Toast.LENGTH_SHORT).show();
    }
}