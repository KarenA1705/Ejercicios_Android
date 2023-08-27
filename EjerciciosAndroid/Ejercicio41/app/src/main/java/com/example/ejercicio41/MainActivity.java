package com.example.ejercicio41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton r1,r2;
    private EditText et1,et2;
    private TextView et3,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        tv1 = findViewById(R.id.textView);
        et3 = findViewById(R.id.et3);
    }
    public void operar(View view){
        int v1 = Integer.parseInt(et1.getText().toString());
        int v2 = Integer.parseInt(et2.getText().toString());
        if(r1.isChecked()==true)
        {
            int suma = v1 + v2;
            et3.setText(String.valueOf(suma));
        }
        else if(r2.isChecked()==true) {
            int resta = v1 - v2;
            et3.setText(String.valueOf(resta));
        }
    }
    public void finalizar(View view){
        finish();
    }
}