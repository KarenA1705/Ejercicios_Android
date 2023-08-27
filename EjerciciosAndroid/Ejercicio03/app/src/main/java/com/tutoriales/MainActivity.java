package com.tutoriales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1,tv2;
    private CheckBox check1,check2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
    }
    public void operar(View view){
        tv2.setText("");
        tv1.setText("");
        if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())
        {
            tv2.setText("Digite los numeros pedidos");
        }
        else
        {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int n1 = Integer.parseInt(valor1);
            int n2 = Integer.parseInt(valor2);
            String resul = "";
            if(check2.isChecked() == true)
            {
                int suma = n1 + n2;
                resul = "La suma es: "+suma;
            }
            if(check1.isChecked() == true)
            {
                int resta = n1 - n2;
                resul = resul + " La resta es: "+resta;
            }
            tv1.setText(resul);
        }
    }
}