package com.example.portugaletego.vista;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.DragEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.portugaletego.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJuego1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJuego1 extends Fragment implements View.OnLongClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView recogida;

    private View vista;


    public FragmentJuego1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentJuego.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentJuego1 newInstance(String param1, String param2) {
        FragmentJuego1 fragment = new FragmentJuego1();
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
        vista= inflater.inflate(R.layout.fragment_juego1, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        ImageView imgPasarela, imgAscensor, imgTensor, imgTransbordador;

        TextView placeholder1, placeholder2, placeholder3, placeholder4;

        imgPasarela = vista.findViewById(R.id.imgTxtPasarela);
        imgAscensor = vista.findViewById(R.id.imgTxtAscensor);
        imgTensor = vista.findViewById(R.id.imgTxtTensor);
        imgTransbordador = vista.findViewById(R.id.imgTxtTransbordador);

        placeholder1 = vista.findViewById(R.id.placeholder1);
        placeholder2 = vista.findViewById(R.id.placeholder2);
        placeholder3 = vista.findViewById(R.id.placeholder3);
        placeholder4 = vista.findViewById(R.id.placeholder4);

        imgPasarela.setOnLongClickListener(this);
        imgAscensor.setOnLongClickListener(this);
        imgTensor.setOnLongClickListener(this);
        imgTransbordador.setOnLongClickListener(this);

        placeholder1.setOnDragListener(drag);
        placeholder2.setOnDragListener(drag);
        placeholder3.setOnDragListener(drag);
        placeholder4.setOnDragListener(drag);


    }

    @Override
    public boolean onLongClick(View v) {
        recogida = (ImageView) v;
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        ClipData dragData = new ClipData(
                (CharSequence) v.getTag(),
                new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                item);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);
        v.startDragAndDrop(dragData,
                myShadow,
                null,
                0
        );
        return true;
    }

    View.OnDragListener drag = (v, event) -> {
        int dragEvent = event.getAction();
        switch (dragEvent) {
            case DragEvent.ACTION_DROP:
                if (v.getId() == R.id.placeholder1 && recogida.getId() == R.id.imgTxtTensor) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(this.getContext(),
                                    "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else if (v.getId() == R.id.placeholder2 && recogida.getId() == R.id.imgTxtAscensor) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(this.getContext(),
                                    "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else if (v.getId() == R.id.placeholder3 && recogida.getId() == R.id.imgTxtTransbordador) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(this.getContext(),
                                    "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else if (v.getId() == R.id.placeholder4 && recogida.getId() == R.id.imgTxtPasarela) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(this.getContext(),
                                    "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else{
                    Toast toast1 =
                            Toast.makeText(this.getContext(),
                                    "Tu opcion NO esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
        }
        return true;
    };
}