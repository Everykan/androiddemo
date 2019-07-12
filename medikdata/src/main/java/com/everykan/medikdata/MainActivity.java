package com.everykan.medikdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonObtener;
    private Button botonCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonObtener = (Button) findViewById(R.id.ObtenerLecturas);
        botonCrear = (Button) findViewById(R.id.CrearLecturas);

        botonObtener.setOnClickListener(this);
        botonCrear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getTag().toString()) {

            case "1":
                intent = new Intent(this,MostrarLecturasActivity.class);
                break;
            case "2":
                intent = new Intent(this,FormCrearLecturaActivity.class);
                break;

        }

        startActivity(intent);

    }

}
