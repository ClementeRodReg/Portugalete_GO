package com.example.portugaletego.vista;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.modelo.Enunciados;
import com.example.portugaletego.modelo.Respuestas;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Enunciado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Enunciado extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View vista;
    private LinearLayout LayoutPreguntas, LayoutEleccion;
    private TextView enunciado;

    BBDD appDatabase;
    private Button pj1, pj2, pj3, pj4, pj5;

    int id;

    public Fragment_Enunciado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTextos.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Enunciado newInstance(String param1, String param2) {
        Fragment_Enunciado fragment = new Fragment_Enunciado();
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
        vista= inflater.inflate(R.layout.fragment_enunciados, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        LayoutPreguntas = view.findViewById(R.id.LayoutPreguntas);
        enunciado = view.findViewById(R.id.textoJuegos);
        Context ctx = getContext();


        appDatabase = BBDD.getDatabase(ctx.getApplicationContext());


        id= obtenerId();
        int contadorSaltos = obtenerContador();
        if(id == 2){
            System.out.println(contadorSaltos);
            switch(contadorSaltos){
                case 0: escribirEnunciadosEjer3(enunciado, contadorSaltos); break;
                case 2: escribirEnunciadosEjer3(enunciado, 1); break;
                case 4: escribirEnunciadosEjer3(enunciado, 2); break;
                case 6: escribirEnunciadosEjer3(enunciado, 3); break;
                case 8: escribirEnunciadosEjer3(enunciado, 4); break;
            }

        }
        if(id == 3){
            System.out.println(contadorSaltos);
            switch(contadorSaltos){
                case 0: escribirEnunciadosEjer4(enunciado, contadorSaltos); break;
                case 2: escribirEnunciadosEjer4(enunciado, 1); break;
                case 4: escribirEnunciadosEjer4(enunciado, 2); break;
                case 6: escribirEnunciadosEjer4(enunciado, 3); break;
                case 8: escribirEnunciadosEjer4(enunciado, 4); break;
            }

        }
        else{
            escribirEnunciados(enunciado, id);
        }
    }

    public int obtenerId(){
        Activity a = getActivity();
        int id = ((ActivityJuegos) a).getId();
        return id;
    }

    public int obtenerContador(){
        Activity a = getActivity();
        int contador = ((ActivityJuegos) a).getContadorSaltos();
        return contador;
    }
    void escribirEnunciados(TextView enunciado, int id){
        String opcionActual = Enunciados.textos[id];
        enunciado.setText(opcionActual);
    }

    //RELLENAR PARA EL EJER 4
    void escribirEnunciadosEjer4(TextView enunciado, int contador){
        String opcionActual = appDatabase.daoEnunciados().obtenerEnunciadosPorIdLugar(3).get(contador).getTexto();
        enunciado.setText(opcionActual);
    }

    void escribirEnunciadosEjer3(TextView enunciado, int contador){
        String opcionActual = appDatabase.daoEnunciados().obtenerEnunciadosPorIdLugar(2).get(contador).getTexto();
        enunciado.setText(opcionActual);
    }

}