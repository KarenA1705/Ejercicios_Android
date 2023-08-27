package com.example.ejercicio20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
        bt1 = findViewById(R.id.bt1);
    }
    public void ocultar(View view)
    {
        bt1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);
    }
}