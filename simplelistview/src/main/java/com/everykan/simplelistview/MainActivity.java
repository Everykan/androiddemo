package com.everykan.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] valores = {"Pepín","Verónica","José","Luis","Lucia","Manuel","Jordi","Pepe","Amanda","María","Alexander","Gabriela","Sergi","Melixza","Gabriela","Tatiana","Marcel"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.idListView);

        // necesitamos un adaptador

        // pasaremos 3 parámetros al construtor son:

        // 1.- contexto
        // 2.- tipo de gráfico o como se va a ver
        // 3.- el array de Strings...
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, valores);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, valores);

        listView.setAdapter(adapter);


    }
}
