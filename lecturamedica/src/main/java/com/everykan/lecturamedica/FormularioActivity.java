package com.everykan.lecturamedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.everykan.lecturamedica.model.Lectura;

import java.util.Date;

public class FormularioActivity extends AppCompatActivity {

    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        boton = (Button) findViewById(R.id.button);




        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.d("***", "click en botón");

                // 1.- Recoger los valores de los TextEdit

                // 2.- Instanciar con esos valores una lectura

                Lectura lectura = new Lectura();

                lectura.setDiastolica(0);
                lectura.setSistolica(0);
                lectura.setPeso(0);
                lectura.setFechaHora(new Date());

                Log.d("****","Vamos a guardar la lectura: " + lectura.toString());



                // 3.- Guardar la lectura en la base de datos
                // 4.- A través de un Intent cambiar de Activity para mostrar el listado

            }
        });

    }
}
