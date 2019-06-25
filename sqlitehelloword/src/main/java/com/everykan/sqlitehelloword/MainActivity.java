package com.everykan.sqlitehelloword;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    EditText et1;
    EditText et2;
    EditText et3;
    Button bt1;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.idNombre);
        et2 = (EditText) findViewById(R.id.idApellido1);
        et3 = (EditText) findViewById(R.id.idApellido2);
        bt1 = (Button) findViewById(R.id.idBoton1);
        bt2 = (Button) findViewById(R.id.idBoton2);

        myDB = new DatabaseHelper(this);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // definimos los campos que tenemos en el formulario
                // string y usamos el getText()
                String nombre = et1.getText().toString(); //
                String apellido1 = et2.getText().toString(); //
                String apellido2 = et3.getText().toString(); //

                // vamos a crear un registro
                String nombreCompleto = apellido1 + " " + apellido2 + " " + nombre;

                // mostramos en la parte inferior de la pantalla en el android
                // los datos que hemos colocado tipo string "nombreCompleto"
                Toast.makeText(MainActivity.this, nombreCompleto, Toast.LENGTH_LONG).show();
                // invocamos la inserción del registro de datos en la DB * Insert *
                myDB.insertData(nombre,apellido1,apellido2);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Cursor cursor = myDB.getAll();

                if(cursor == null || cursor.getCount() == 0) {
                    return;
                }

                while(cursor.moveToNext()){
                    int codigo = cursor.getInt(0);
                    String nombre = cursor.getString(1);
                    String apellido1 = cursor.getString(2);
                    String apellido2 = cursor.getString(3);

                    String amigo = codigo + " " + nombre + " " + apellido1 + " " + apellido2;

                    Log.d("***","Amigo " + amigo);

                }


            }
        });

    }
}
