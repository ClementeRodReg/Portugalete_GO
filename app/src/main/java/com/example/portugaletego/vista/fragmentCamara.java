package com.example.portugaletego.vista;

import static android.app.Activity.RESULT_OK;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.portugaletego.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentCamara#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentCamara extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "grupo";

    // TODO: Rename and change types of parameters
    private int id_juego;
    private int id_grupo;
    Button btnCamara;
    ImageView imagen;
    private FirebaseAuth mAuth;
    FirebaseStorage storage;
    StorageReference storageRef;
    public fragmentCamara() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @return A new instance of fragment fragmentCamara.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentCamara newInstance(int id, int grupo) {
        fragmentCamara fragment = new fragmentCamara();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, id);
        args.putInt(ARG_PARAM2, grupo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id_juego = getArguments().getInt(ARG_PARAM1);
            id_grupo = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camara, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        btnCamara = view.findViewById(R.id.btnCamara);
        imagen = view.findViewById(R.id.fotoSacada);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
                enseñarTexto();
            }
        });

    }

    private void enseñarTexto() {
    }

    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imgBitmap);
            mAuth = FirebaseAuth.getInstance();
            String carpetaGrupo="";

            if(id_grupo == 0)
                carpetaGrupo="r_g1";
            else if(id_grupo == 1)
                carpetaGrupo="r_g2";
            else
                carpetaGrupo="r_g3";

            ContentResolver resolver = getContext().getContentResolver();
            ContentValues values = new ContentValues();
            OutputStream fos = null;
            String nombreFoto = "";
            File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
            if (id_juego == 3) {
                nombreFoto = "RespuestaEjer3";
                storage = FirebaseStorage.getInstance("gs://portugo-614ca.appspot.com");
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        File Dir = new File(files[i].getAbsolutePath());
                        File[] filesInDir = Dir.listFiles();
                        for (int num = 0; num < filesInDir.length; num++) {
                            if (filesInDir[num].getName().contains(nombreFoto)) {
                                filesInDir[num].delete();
                            }
                        }
                    }
                }
            } else if (id_juego == 4) {
                nombreFoto = "RespuestaEjer4";
                storage = FirebaseStorage.getInstance("gs://portugo-614ca.appspot.com");
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        File Dir = new File(files[i].getAbsolutePath());
                        File[] filesInDir = Dir.listFiles();
                        for (int num = 0; num < filesInDir.length; num++) {
                            if (filesInDir[num].getName().contains(nombreFoto)) {
                                filesInDir[num].delete();
                            }
                        }
                    }
                }
            }
            values.put(MediaStore.Images.Media.DISPLAY_NAME, nombreFoto);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/PortuGO");
            values.put(MediaStore.Images.Media.IS_PENDING, 1);

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
            Uri imageUri = resolver.insert(collection, values);

            try {
                fos = resolver.openOutputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            values.clear();
            values.put(MediaStore.Images.Media.IS_PENDING, 0);
            try {
                resolver.update(imageUri, values, null, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            boolean guardado = imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            if (guardado) {
                Toast.makeText(getView().getContext(), "La imagen ha sido guardada.", Toast.LENGTH_SHORT).show();
            }
            storageRef = storage.getReference();
            Uri file = Uri.fromFile(new File("/sdcard/Pictures/PortuGO/"+nombreFoto+".jpg"));
            StorageReference riversRef = storageRef.child(carpetaGrupo+"/ejer"+id_juego+"/"+file.getLastPathSegment());
            UploadTask uploadTask = riversRef.putFile(file);

            // Register observers to listen for when the download is done or if it fails
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    System.out.println("hola");
                }
            });

        }
    }

}
