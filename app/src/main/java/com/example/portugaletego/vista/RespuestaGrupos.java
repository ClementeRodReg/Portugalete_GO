package com.example.portugaletego.vista;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

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
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance("gs://portugo-614ca.appspot.com");
        ImageView ejerfoto = view.findViewById(R.id.fotoSacada);
        TextView descejer = view.findViewById(R.id.desc);
        Button aprobar = view.findViewById(R.id.Aprobarbtn);
        LinearLayout ll1 = view.findViewById(R.id.layoutg1);
        ll1.setVisibility(View.INVISIBLE);

        if (grupo != null) {
            if (grupo.equals("r_g1"))
                ngrupo.setText("GRUPO 1");
            else if (grupo.equals("r_g2"))
                ngrupo.setText("GRUPO 2");
            else
                ngrupo.setText("GRUPO 3");
        }else{
            grupo="nada";
        }
        if (grupo.equals("r_g1")) {
            ll1.setVisibility(View.VISIBLE);
            storageRef = storage.getReference();
            StorageReference islandRef = storageRef.child(grupo + "/ejer4" + "/RespuestaEjer4.jpg");
            descejer.setText("ejercicio 4");
            final long ONE_MEGABYTE = 1024 * 1024;
            islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    // Data for "images/island.jpg" is returns, use this as needed
                    Bitmap bitmapimg = (bytes == null || bytes.length == 0) ? null : BitmapFactory
                            .decodeByteArray(bytes, 0, bytes.length);
                    ejerfoto.setImageBitmap(bitmapimg);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });

            aprobar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getView().getContext(), "Grupo 1 ha aprobado el ejercicio 4", Toast.LENGTH_SHORT).show();
                    ll1.setVisibility(View.INVISIBLE);
                }
            });
        }else{
            ll1.setVisibility(View.INVISIBLE);
        }
    }
}