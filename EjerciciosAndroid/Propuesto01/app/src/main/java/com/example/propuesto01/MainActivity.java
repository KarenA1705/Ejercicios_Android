package com.example.propuesto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/*
Realizar un programa que genere un número aleatorio entre 1 y 50, pedir que el operador lo adivine, informar si ganó o si
el número es mayor o menor al ingresado. Cuando el operador lo adivine incrementar en uno el puntaje de juego.
Cada vez que se ingrese a la aplicación mostrar el puntaje actual, es decir recordar el puntaje en un archivo de preferencia
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}