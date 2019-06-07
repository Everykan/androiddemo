package com.everykan.practicaconstrainlayout;

import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Date fecha = new Date();


    // monitorizar con un "policias"
    /*
    public MainActivity(){
        Log.d("INFO","DENTRO DE MÉTODO CONSTRUCTOR");
    }
    static {
        Log.d("INFO","SE INICIALIZA EL 'MUNDO ESTATICO'");
    }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Monitorizar cuando está ON PAUSE
        // Log.d("INFO","ON PAUSE");
        fecha = new Date(); // fecha del sistema

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Monitorizar cuando está ON RESUME
        // Log.d("INFO","ON RESUME");

        long milisengundos = (new Date()).getTime() - fecha.getTime(); //
        StringBuilder sb = new StringBuilder();
        sb.append(milisengundos/1000).append(" Segundos en 2do Plano");
    }
}
