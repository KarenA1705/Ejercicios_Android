package com.example.ejercicio16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);


    }
    public void cargarArticulo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descrip = et2.getText().toString();
        String prec = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",descrip);
        registro.put("precio",prec);
        db.insert("articulos",null,registro);
        db.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this,"Se cargaron los datos",Toast.LENGTH_SHORT).show();

    }
    public void consultarPorCodigo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = et1.getText().toString();
        Cursor fila = db.rawQuery("select descripcion,precio from articulos where codigo=" + cod, null);
        if(fila.moveToFirst())
        {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        }
        else {
            Toast.makeText(this,"No existe un articulo con dicho codigo",Toast.LENGTH_SHORT).show();
        }
        db.close();

    }
    public void consularPorDescripcion(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String descrip = et2.getText().toString();
        Cursor fila = db.rawQuery("select codigo,precio from articulos where descripcion='" + descrip +"'", null);
        if(fila.moveToFirst())
        {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        }
        else {
            Toast.makeText(this,"No existe articulo con dicha descripcion",Toast.LENGTH_SHORT).show();
        }
        db.close();

    }
    public void eliminarPorCodigo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        int cant = db.delete("articulos", "codigo="+cod,null);
        db.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        if(cant == 1)
        {
            Toast.makeText(this,"Articulo elimando correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No existe el articulo",Toast.LENGTH_SHORT).show();
        }

    }
    public void modificarAritculo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descrip = et2.getText().toString();
        String precio = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",descrip);
        registro.put("precio",precio);
        int cant = db.update("articulos",registro,"codigo="+cod,null);
        db.close();
        if(cant == 1)
        {
            Toast.makeText(this,"Articulo modificado correctamente",Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
            et3.setText("");
        }
        else {
            Toast.makeText(this,"No existe el articulo",Toast.LENGTH_SHORT).show();
        }
    }
}