package com.everykan.lecturamedica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.everykan.lecturamedica.model.Lectura;
import com.everykan.lecturamedica.model.LecturaServices;
import com.everykan.lecturamedica.model.LecturaServicesImpl;
import com.everykan.lecturamedica.model.LecturaServicesSQLite;

import java.util.Date;

public class FormularioActivity extends AppCompatActivity {

    private Button boton;
    private LecturaServices lecturaServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.lecturaServices = new LecturaServicesSQLite(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.d("***", "click en botón");

                // 1.- Recoger los valores de los TextEdit

                EditText lpeso = (EditText)findViewById(R.id.idPeso);
                EditText ldiastolica = (EditText)findViewById(R.id.idDiastolica);
                EditText lsistolica = (EditText)findViewById(R.id.idSistolica);

                double peso = Double.parseDouble(lpeso.getText().toString());
                double diastolica = Double.parseDouble(ldiastolica.getText().toString());
                double sistolica = Double.parseDouble(lsistolica.getText().toString());

                // 2.- Instanciar con esos valores una lectura

                Lectura lectura = new Lectura();

                lectura.setDiastolica(diastolica);
                lectura.setSistolica(sistolica);
                lectura.setPeso(peso);
                lectura.setFechaHora(new Date());

                Log.d("****","Vamos a guardar la lectura: " + lectura.toString());

                // 3.- Guardar la lectura ....( 3.1.- Segundo método, en la base de datos )

                //lecturaServices es una variable de instancia. Sólo hay una definida arriba

                lecturaServices.create(lectura);

                // 4.- A través de un Intent cambiar de Activity para mostrar el listado
                // Hemos de utilizar un Intent para ir a la MainActivity que es la que tiene la lista...

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
