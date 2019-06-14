package com.everykan.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] valores = {"Pepín","Verónica","José","Luis","Lucia","Manuel","Jordi","Pepe","Amanda","María","Alexander","Gabriela","Sergi","Melixza","Gabriela","Tatiana","Marcel"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);

        // necesitamos un adaptador

        // le pasaremos 3 parámetros al constructor son:

        // 1.- contexto
        // 2.- tipo de gráfico o como se va a ver
        // 3.- el array de Strings...
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, valores);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, valores);

        listView.setAdapter(adapter);

        // vamos a añadir un listener!
        // es el que esta pendiente cuando ocurre algún tipo de evento en la app; ejemplo un clic
        // y saber en donde o quien

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String texto = "position: " + position + "de Nombre: " + valores[position];
                texto += " id: " + id + " view " + view.getClass().getSimpleName();
                texto += " parent: " + parent.getClass().getSimpleName();

                Toast.makeText(getApplicationContext(),texto, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
