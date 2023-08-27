package com.example.ejercicio39;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int cordX,cordY;
    private Lienzo fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cordX = 100;
        cordY = 100;
        ConstraintLayout layout1 = findViewById(R.id.layout1);
        fondo = new Lienzo(this);
        fondo.setOnTouchListener(this::onTuch
        );
        layout1.addView(fondo);

    }
    public boolean onTuch(View v, MotionEvent event){
        cordX = (int) event.getX();
        cordY = (int) event.getY();
        fondo.invalidate();
        return true;
    }
    class Lienzo extends View{
        public Lienzo(Context context){
            super(context);
        }
        protected void onDraw (Canvas canvas){
            canvas.drawRGB(135, 206, 150);
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStrokeWidth(4);
            pincel1.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(cordX,cordY,20,pincel1);
        }


    }
}