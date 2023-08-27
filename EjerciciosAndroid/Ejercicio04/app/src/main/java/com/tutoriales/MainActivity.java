package com.tutoriales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView tv1,tv2;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        spinner1 = findViewById(R.id.spinner);
        String [] opciones = {"sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adapter);
    }
    public void operar(View view)
    {
        tv2.setText("");
        tv1.setText("");
        if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())
        {
            tv2.setText("Por favor, digite los numeros pedidos");
        }
        else
        {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int n1 = Integer.parseInt(valor1);
            int n2 = Integer.parseInt(valor2);
            String select = spinner1.getSelectedItem().toString();

            if (select.equals("sumar")) {
                int suma = n1+n2;
                String resul = String.valueOf(suma);
                tv1.setText(resul);
            }
            if (select.equals("restar")) {
                int resta = n1-n2;
                String resul = String.valueOf(resta);
                tv1.setText(resul);
            }
            if (select.equals("multiplicar")) {
                int mult = n1*n2;
                String resul = String.valueOf(mult);
                tv1.setText(resul);
            }
            if (select.equals("dividir")) {
                int divi = n1/n2;
                String resul = String.valueOf(divi);
                tv1.setText(resul);
            }
        }
    }
}