package com.example.portugaletego.vista;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.controlador.DAOPuntuacion;
import com.example.portugaletego.modelo.Puntuacion;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRanking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRanking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView pos1_gr, pos2_gr, pos3_gr, pos4_gr, pos5_gr, pos6_gr, pos7_gr, pos8_gr;
    private TextView pos1_pt, pos2_pt, pos3_pt, pos4_pt, pos5_pt, pos6_pt, pos7_pt, pos8_pt;

    BBDD appDatabase;

    public FragmentRanking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRanking.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRanking newInstance(String param1, String param2) {
        FragmentRanking fragment = new FragmentRanking();
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
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        Context ctx = getContext();

        pos1_gr = view.findViewById(R.id.posicion1_grupo1);
        pos2_gr = view.findViewById(R.id.posicion1_grupo2);
        pos3_gr = view.findViewById(R.id.posicion1_grupo3);
        pos4_gr = view.findViewById(R.id.posicion1_grupo4);
        pos5_gr = view.findViewById(R.id.posicion1_grupo5);
        pos6_gr = view.findViewById(R.id.posicion1_grupo6);
        pos7_gr = view.findViewById(R.id.posicion1_grupo7);
        pos8_gr = view.findViewById(R.id.posicion1_grupo8);

        pos1_pt = view.findViewById(R.id.posicion1_puntos1);
        pos2_pt = view.findViewById(R.id.posicion1_puntos2);
        pos3_pt = view.findViewById(R.id.posicion1_puntos3);
        pos4_pt = view.findViewById(R.id.posicion1_puntos4);
        pos5_pt = view.findViewById(R.id.posicion1_puntos5);
        pos6_pt = view.findViewById(R.id.posicion1_puntos6);
        pos7_pt = view.findViewById(R.id.posicion1_puntos7);
        pos8_pt = view.findViewById(R.id.posicion1_puntos8);

        appDatabase = BBDD.getDatabase(ctx.getApplicationContext());
        DAOPuntuacion puntuacionDao = appDatabase.daoPuntuacion();

        List<Puntuacion> ranking = appDatabase.daoPuntuacion().obtenerRanking();

        puntuacionDao.obtenerTop8Puntuaciones().observe(getViewLifecycleOwner(), puntuaciones -> {
            TextView[] grupos = {pos1_gr, pos2_gr, pos3_gr, pos4_gr, pos5_gr, pos6_gr, pos7_gr, pos8_gr};
            TextView[] puntos = {pos1_pt, pos2_pt, pos3_pt, pos4_pt, pos5_pt, pos6_pt, pos7_pt, pos8_pt};

            for (int i = 0; i < puntuaciones.size(); i++) {
                Puntuacion puntuacion = puntuaciones.get(i);
                if (i < grupos.length) {
                    // Aquí asumimos que tienes una manera de extraer el grupo de tu puntuacion_id
                    // y que tu puntuacion_id es algo como "grupo_fecha"
                    String grupo = puntuacion.getPuntuacion_id().split("_")[0];
                    grupos[i].setText(grupo);
                    puntos[i].setText(String.valueOf(puntuacion.getPuntos()));
                }
            }

            // Si hay menos de 8 puntuaciones, limpia los TextViews restantes
            for (int i = puntuaciones.size(); i < grupos.length; i++) {
                grupos[i].setText("");
                puntos[i].setText("");
            }
        });

        /*
        pos1_gr.setText(ranking.get(0).getPuntuacion_id());
        pos1_pt.setText(Integer.toString(ranking.get(0).getPuntos()));

        pos2_gr.setText(ranking.get(1).getPuntuacion_id());
        pos2_pt.setText(Integer.toString(ranking.get(1).getPuntos()));

        pos3_gr.setText(ranking.get(2).getPuntuacion_id());
        pos3_pt.setText(Integer.toString(ranking.get(2).getPuntos()));

        pos4_gr.setText(ranking.get(3).getPuntuacion_id());
        pos4_pt.setText(Integer.toString(ranking.get(3).getPuntos()));

        pos5_gr.setText(ranking.get(4).getPuntuacion_id());
        pos5_pt.setText(Integer.toString(ranking.get(4).getPuntos()));

        pos6_gr.setText(ranking.get(5).getPuntuacion_id());
        pos6_pt.setText(Integer.toString(ranking.get(5).getPuntos()));

        pos7_gr.setText(ranking.get(6).getPuntuacion_id());
        pos7_pt.setText(Integer.toString(ranking.get(6).getPuntos()));

        pos8_gr.setText(ranking.get(7).getPuntuacion_id());
        pos8_pt.setText(Integer.toString(ranking.get(7).getPuntos()));
    */

    }




    /*
    private void insertarYLimpiarPuntuaciones(DAOPuntuacion dao, Puntuacion nuevaPuntuacion) {
        // Obtener las 8 puntuaciones más altas
        List<Puntuacion> topPuntuaciones = dao.obtenerTop8Puntuaciones();

        if (topPuntuaciones.size() < 8) {
            // Si hay menos de 8 puntuaciones, simplemente insertamos la nueva puntuación.
            dao.insertarPuntuacion(nuevaPuntuacion);
        } else {
            // Verificar si la nueva puntuación es mayor que la más baja de las 8 más altas
            Puntuacion minimaDeLasTop = topPuntuaciones.get(topPuntuaciones.size() - 1); // Debido a que están ordenadas de mayor a menor
            if (nuevaPuntuacion.getPuntos() > minimaDeLasTop.getPuntos()) {
                dao.insertarPuntuacion(nuevaPuntuacion);
                // Eliminar puntuaciones fuera del top 8
                dao.eliminarPuntuacionesBajas();
            }
        }
    }


     */
}