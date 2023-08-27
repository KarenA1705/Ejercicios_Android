package com.example.ejercicio47;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listaPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("Juan", 'm'));
        listaPersonas.add(new Persona("pedro",'m'));
        listaPersonas.add(new Persona("luis",'m'));
        listaPersonas.add(new Persona("ana",'f'));
        listaPersonas.add(new Persona("carla",'f'));
        listaPersonas.add(new Persona("maria",'f'));
        listaPersonas.add(new Persona("gustavo",'m'));
        listaPersonas.add(new Persona("carlos",'m'));
        listaPersonas.add(new Persona("marta",'f'));
        listaPersonas.add(new Persona("luisa",'f'));
        listaPersonas.add(new Persona("fernanda",'f'));
        listaPersonas.add(new Persona("jose",'m'));
        listaPersonas.add(new Persona("paola",'f'));
        listaPersonas.add(new Persona("lucrecia",'f'));
        listaPersonas.add(new Persona("oscar",'m'));
        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(this);
        ListView list1 = findViewById(R.id.list1);
        list1.setAdapter(adaptadorPersonas);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,listaPersonas.get(i).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

    }
    class AdaptadorPersonas extends ArrayAdapter<Persona>{
        AppCompatActivity appCompatActivity;
        AdaptadorPersonas(AppCompatActivity context){
            super(context,R.layout.persona,listaPersonas);
            appCompatActivity = context;
        }
        public View getView(int posicion, View convertView, ViewGroup parent){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listaPersonas.get(posicion).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imageView2);
            if(listaPersonas.get(posicion).getGenero()=='m')
            {
                imageView1.setImageResource(R.mipmap.hombre);
            }
            else {
                imageView1.setImageResource(R.mipmap.mujer);
            }
            return item;
        }






    }
}