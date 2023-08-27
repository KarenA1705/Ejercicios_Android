package com.example.ejercicio45;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.telefono){
            Toast.makeText(this,"Se presiono el icono del telefono",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.camara){
            Toast.makeText(this,"Se presiono el icono de la camara",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.opcion1){
            Toast.makeText(this,"Se presiono la opcion 1 del menu",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.opcion2){
            Toast.makeText(this,"Se presiono la opcion 2 del menuo",Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.opcion3){
            Toast.makeText(this,"Se presiono la opcion 3 del menu",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}