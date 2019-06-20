package com.everykan.listbanderas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView banderas;

    private String [][] datos = {

            {"Alemania","Europa"},
            {"Argentina","America del Sur"},
            {"Armenia","Asiatico"},
            {"Azerbaijan","Europa"},
            {"Bélgica","Europa"},
            {"Canada","Americano"},
            {"Chile","América del Sur"},
            {"Dinamarca","Europa"},
            {"España","Europa"},
            {"Francia","Europa"},
            {"Guinea Ecuatorial","África"},
            {"Honduras","Americano"},
            {"Israel","Asíatico"},
            {"Italia","Europa"},
            {"Panamá","Americano"},
            {"Puerto Rico","Americano"},
            {"Reino Unido","Europa"},
            {"Tayikistan","Asiatico"},
            {"Estados Unidos","Americano"},
            {"Venezuela","América del Sur"}

    };

    private int[] datosImg = {

            R.drawable.alemania,
            R.drawable.argentina,
            R.drawable.armenia,
            R.drawable.azerbaijan,
            R.drawable.belgica,
            R.drawable.canada,
            R.drawable.chile,
            R.drawable.dinamarca,
            R.drawable.espana,
            R.drawable.francia,
            R.drawable.guineaecuatorial,
            R.drawable.honduras,
            R.drawable.israel,
            R.drawable.italia,
            R.drawable.panama,
            R.drawable.puertorico,
            R.drawable.reinounido,
            R.drawable.tayikistan,
            R.drawable.usa,
            R.drawable.venezuela

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banderas = (ListView) findViewById(R.id.idlistview);
        Adaptador adpatador = new Adaptador(this, datos, datosImg);
        banderas.setAdapter(adpatador);

    }
}
