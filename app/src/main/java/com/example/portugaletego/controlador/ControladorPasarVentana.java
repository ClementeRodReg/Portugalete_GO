package com.example.portugaletego.controlador;

import android.content.Intent;

import com.example.portugaletego.vista.MainActivity;
import com.example.portugaletego.vista.VistaMapa;

public class ControladorPasarVentana implements Runnable {
    android.content.Context clase1;
    Class clase2;

    public Intent getMandar() {
        return mandar;
    }

    Intent mandar;
    public ControladorPasarVentana(android.content.Context clase1, Class clase2) {
        this.clase1 = clase1;
        this.clase2 = clase2;
        Thread tcontCA = new Thread(this);
        tcontCA.setPriority(10);
        tcontCA.start();
    }

    @Override
    public void run() {
        //Esperamos a que la transicion del gif termine para pasar de ventana
        try {
            Thread.sleep(6000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mandar = new Intent(clase1, clase2);
    }

}
