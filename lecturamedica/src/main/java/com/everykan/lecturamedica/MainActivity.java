package com.everykan.lecturamedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idLista);

        // setear la lista a un adapter (aparato)

        Adaptador adaptador = new Adaptador(this);

        lista.setAdapter(adaptador);

    }
}
