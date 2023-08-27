package com.example.ejercicio14;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }
    public void grabar(View view)
    {
        String normarchivo=et1.getText().toString();
        normarchivo=normarchivo.replace('/','-');
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(normarchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();

        }catch (IOException e)
        {

        }
        Toast t = Toast.makeText(this,"Datos guardados",Toast.LENGTH_SHORT);
        t.show();
        et1.setText("");
        et2.setText("");
    }
    public void recuperar(View view)
    {
        String normarchivo = et1.getText().toString();
        normarchivo = normarchivo.replace('/','-');
        boolean encontrado = false;
        String [] archivos = fileList();
        for(int i=0;i<archivos.length;i++)
        {
            if(normarchivo.equals(archivos[i]))
            {
                encontrado = true;
            }
        }

        if(encontrado==true)
        {
            try{
                InputStreamReader archivo = new InputStreamReader(openFileInput(normarchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null){
                    todo = todo+linea+"\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);
            }catch (IOException e)
            {

            }
        }
        else
        {
            Toast.makeText(this,"No hay datos guardados para dicha fecha",Toast.LENGTH_LONG).show();
            et2.setText("");
        }
    }
}