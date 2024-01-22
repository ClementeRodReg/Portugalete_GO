package com.example.portugaletego.vista;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.portugaletego.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RespuestaGrupos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RespuestaGrupos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "grupo";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private TextView ngrupo;

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
    public static RespuestaGrupos newInstance(String param1, String param2) {
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
            mParam1 = getArguments().getString(ARG_PARAM1);
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
        ngrupo= view.findViewById(R.id.textvG1);

    }
}