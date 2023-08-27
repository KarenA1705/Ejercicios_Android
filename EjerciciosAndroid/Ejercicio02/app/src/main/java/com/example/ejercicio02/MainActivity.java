package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView tv1,tv2;
    private RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 =findViewById(R.id.tv1);
        tv2 =findViewById(R.id.tv2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);

    }

    public void operar(View view) {
        tv2.setText("");
        if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty() ) {
            tv2.setText("Por favor, digite los numeros pedidos");
        } else {

            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int n1 = Integer.parseInt(valor1);
            int n2 = Integer.parseInt(valor2);

            if (r1.isChecked() == true) {
                int suma = n1 + n2;
                String resultado = String.valueOf(suma);
                tv1.setText(resultado);

            } else if (r2.isChecked() == true) {
                int resta = n1 - n2;
                String resultado = String.valueOf(resta);
                tv1.setText(resultado);
            }
        }
    }

    }
