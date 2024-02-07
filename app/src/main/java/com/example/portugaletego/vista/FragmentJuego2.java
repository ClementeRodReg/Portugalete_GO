package com.example.portugaletego.vista;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portugaletego.R;
import com.example.portugaletego.controlador.BBDD;
import com.example.portugaletego.modelo.Pregunta;
import com.example.portugaletego.modelo.Respuesta;
import com.example.portugaletego.modelo.Respuestas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJuego2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJuego2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "idGrupo";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Respuesta> lstRespuestas;
    List<Respuesta> lstRespuestasCorrectas;
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    BBDD AppDataBase;
    int score = 0;
    int totalQuestion = Respuestas.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    private View vista;

    public FragmentJuego2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentJuego2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentJuego2 newInstance(String param1, String param2) {
        FragmentJuego2 fragment = new FragmentJuego2();
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
        vista = inflater.inflate(R.layout.fragment_juego2, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        Context ctx = getContext();
        AppDataBase = BBDD.getDatabase(ctx.getApplicationContext());
        totalQuestionsTextView = view.findViewById(R.id.total_question);
        lstRespuestasCorrectas = AppDataBase.daoRespuesta().obtenerRespuestasCorrectas();
        questionTextView = view.findViewById(R.id.question);
        ansA = view.findViewById(R.id.ans_A);
        ansB = view.findViewById(R.id.ans_B);
        ansC = view.findViewById(R.id.ans_C);
        ansD = view.findViewById(R.id.ans_D);
        submitBtn = view.findViewById(R.id.submit_btn);


        ansA.setOnClickListener(this::onClick);
        ansB.setOnClickListener(this::onClick);
        ansC.setOnClickListener(this::onClick);
        ansD.setOnClickListener(this::onClick);
        submitBtn.setOnClickListener(this::onClick);

        totalQuestionsTextView.setText("Preguntas totales : " + totalQuestion);

        nuevaPregunta();
    }

    public void onClick(View view) {
        Button btnClick = (Button) view;
        if (btnClick.getId() == R.id.submit_btn) {
            Button btnCorrecto = findButtonWithAnswer(lstRespuestasCorrectas.get(currentQuestionIndex).getTexto());
            boolean respuestaCorrecta = selectedAnswer.equals(lstRespuestasCorrectas.get(currentQuestionIndex).getTexto());

            if (btnCorrecto != null) {
                btnCorrecto.setBackgroundColor(Color.GREEN);
            }

            if (!respuestaCorrecta) {
                // Respuesta incorrecta, colorea el botón seleccionado en rojo
                Button btnEscogido = findButtonWithAnswer(selectedAnswer);
                if (btnEscogido != null) {
                    btnEscogido.setBackgroundColor(Color.RED);
                }
            }
            if (respuestaCorrecta) {
                score++;
            }
            if (currentQuestionIndex + 1 == totalQuestion) {
                // Llama a finishQuiz después de un retraso
                submitBtn.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(() -> {
                    finQuiz();

                }, 1500); // Retraso de 1.5 segundos
            } else {
                // Llama a loadNewQuestion después de un retraso
                submitBtn.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(() -> {
                    currentQuestionIndex++;
                    nuevaPregunta();

                }, 1500); // Retraso de 1.5 segundos
            }
        } else {
            // Botón de respuesta seleccionado
            resetearPreguntas();
            selectedAnswer = btnClick.getText().toString();
            btnClick.setBackgroundColor(Color.LTGRAY);
            submitBtn.setVisibility(View.VISIBLE);
            // Color de selección temporal
        }
    }

    private Button findButtonWithAnswer(String answer) {
        if (ansA.getText().toString().equals(answer)) {
            return ansA;
        } else if (ansB.getText().toString().equals(answer)) {
            return ansB;
        } else if (ansC.getText().toString().equals(answer)) {
            return ansC;
        } else if (ansD.getText().toString().equals(answer)) {
            return ansD;
        }
        return null;
    }

    private void resetearPreguntas() {
        ansA.setBackgroundColor(Color.WHITE);
        ansA.setTextColor(Color.BLACK);
        ansB.setBackgroundColor(Color.WHITE);
        ansB.setTextColor(Color.BLACK);
        ansC.setBackgroundColor(Color.WHITE);
        ansC.setTextColor(Color.BLACK);
        ansD.setBackgroundColor(Color.WHITE);
        ansD.setTextColor(Color.BLACK);
    }

    //llama al metodo resetear
    void nuevaPregunta() {
        resetearPreguntas();

        Pregunta pregunta = AppDataBase.daoPregunta().obtenerPregunta(currentQuestionIndex);
        lstRespuestas = AppDataBase.daoRespuesta().obtenerRespuestasporPregunta(currentQuestionIndex);
        String[] opcionesActuales = new String[lstRespuestas.size()];

        System.out.println(lstRespuestas.size());

        for (int i = 0; i < lstRespuestas.size(); i++)
            opcionesActuales[i] = lstRespuestas.get(i).getTexto();

        List<String> opcionesBarajadas = barajarRespuestas(opcionesActuales);

        questionTextView.setText(pregunta.getTextoPregunta());
        ansA.setText(opcionesBarajadas.get(0));
        ansB.setText(opcionesBarajadas.get(1));
        ansC.setText(opcionesBarajadas.get(2));
        ansD.setText(opcionesBarajadas.get(3));
    }

    private List<String> barajarRespuestas(String[] respuestas) {
        List<String> listaBarajada = new ArrayList<>();
        Random random = new Random();

        // Crea una copia temporal de las respuestas para manipular
        List<String> temp = new ArrayList<>(Arrays.asList(respuestas));

        // Baraja las respuestas
        while (!temp.isEmpty()) {
            int index = random.nextInt(temp.size());
            listaBarajada.add(temp.get(index));
            temp.remove(index);
        }
        return listaBarajada;
    }

    //Solo sale cuando completamos las preguntas ->  Da dos botones para reiniciar o salir del juego
    void finQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Has superado el juego!";
        } else {
            passStatus = "Has fallado :(";
        }

        new AlertDialog.Builder(getContext())
                .setTitle(passStatus)
                .setMessage("Puntuación " + score + " de " + totalQuestion)
                .setPositiveButton("Reiniciar", (dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Salir", (dialogInterface, i) -> salir())
                .setCancelable(false)
                .show();
    }

    public void aprobarEjercicio(String grupo) {

        String puntuacionId = grupo + "_" + obtenerFechaActual(); // Asume la existencia de obtenerFechaActual()
        // Incrementar puntos en 1 (o el valor deseado)
        AppDataBase.daoPuntuacion().incrementarPuntos(puntuacionId, score);
        // Puedes llamar a avisoA(parte) aquí si quieres mantener la notificación
    }

    public String obtenerFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }

    //Metodo para salir del activity desde el propio fragment -> solo se accede desde un AlertDialog
    private void salir() {
        aprobarEjercicio(mParam1);
        Activity a = getActivity();
        MediaPlayer mp2 = ((ActivityJuegos) a).getMp();
        ((ActivityJuegos) a).volver(mp2);
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        nuevaPregunta();
    }
}