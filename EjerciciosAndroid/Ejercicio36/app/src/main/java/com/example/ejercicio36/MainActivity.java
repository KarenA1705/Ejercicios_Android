package com.example.ejercicio36;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout layout = findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout.addView(fondo);
    }

    class Lienzo extends View{
        public Lienzo(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas){
            canvas.drawRGB(255,255,255);
            Paint pincel1 = new Paint();
            pincel1.setARGB(255,0,0,0);
            pincel1.setTextSize(80);
            Typeface tf = Typeface.createFromAsset(getAssets(),"CAC Champagne.ttf");
            pincel1.setTypeface(tf);
            canvas.drawText("Holaaaa Mundoo",0,120,pincel1);
        }
    }
}