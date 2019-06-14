package com.everykan.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    private String [][] datos = {

            {"Chet Baker","Jazz","2:49","9","Descripcion del album del artista"},
            {"Paco Rivera","Latin-Jazz","3:10","10","Descripcion del album del artista"},
            {"Lucia Mendez","Jazz","3:10","7","Descripcion del album del artista"},
            {"Annabel Duran","Bosanova","2:49","8","Descripcion del album del artista"},
            {"Chet Baker","Clasica","4:15","6","Descripcion del album del artista"},
            {"Pedro Pérez","Pop","2:49","5","Descripcion del album del artista"},
            {"Miguel García","Jazz","2:49","8","Descripcion del album del artista"},
            {"Luis Enrique","Salsa","2:49","9","Descripcion del album del artista"},

    };

    private int[] datosImg = {

            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4,
            R.drawable.imagen5,
            R.drawable.imagen6,
            R.drawable.imagen7,
            R.drawable.imagen8

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.klista);
        Adaptador adpatador = new Adaptador(this, datos, datosImg);
        lista.setAdapter(adpatador);

    }
}
