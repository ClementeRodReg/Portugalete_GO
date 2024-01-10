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

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.portugaletego.R;

import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCamara2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCamara2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btnCamara;
    ImageView imagen;
    public FragmentCamara2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentCamara.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCamara2 newInstance(String param1, String param2) {
        FragmentCamara2 fragment = new FragmentCamara2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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

        btnCamara=view.findViewById(R.id.btnCamara);
        imagen=view.findViewById(R.id.fotoSacada);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1 && resultCode== RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap= (Bitmap) extras.get("data");
            imagen.setImageBitmap(imgBitmap) ;

            ContentResolver resolver = getContext().getContentResolver();
            ContentValues values = new ContentValues();
            OutputStream fos = null;
            String nombreFoto = "RespuestaEjer3punto1";
            values.put(MediaStore.Images.Media.DISPLAY_NAME, nombreFoto);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/PortuGO");
            values.put(MediaStore.Images.Media.IS_PENDING, 1);

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
            Uri imageUri= resolver.insert(collection, values);

            try {
                fos=resolver.openOutputStream(imageUri);
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

            if(guardado){
                Toast.makeText(getView().getContext(), "La imagen ha sido guardada.", Toast.LENGTH_SHORT).show();
            }

        }
    }
}