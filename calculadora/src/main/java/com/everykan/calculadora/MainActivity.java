package com.everykan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double valor = 0.0;
    private TextView textView;
    String valor1 = "";
    int cifra = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.display);
        textView.setText( valor + "" );
    }

    public void botonPulsado(View view) {

        int cifra = 0;
        String accion = "";
        String calcula = "";
        int valor2 = 0;

        switch (view.getId()) {

            case R.id.boton0:
                cifra = 0;
                break;
            case R.id.boton1:
                cifra = 1;
                break;
            case R.id.boton2:
                cifra = 2;
                break;
            case R.id.boton3:
                cifra = 3;
                break;
            case R.id.boton4:
                cifra = 4;
                break;
            case R.id.boton5:
                cifra = 5;
                break;
            case R.id.boton6:
                cifra = 6;
                break;
            case R.id.boton7:
                cifra = 7;
                break;
            case R.id.boton8:
                cifra = 8;
                break;
            case R.id.boton9:
                cifra = 9;
                break;
            case R.id.decimal:
                // guardar valor entero para luego utilizar en conversiones posteriores
                // agregar al string de cifra el punto decimal en pantalla
                // y encender un flag para saber que a partir de acá estamos leyendo el
                // otro valor
                accion = "decimal";
                break;
            case R.id.suma:
                accion = "sumar";
                break;
            case R.id.resta:
                accion = "restar";
                break;
            case R.id.multiplica:
                accion = "multiplicar";
                break;
            case R.id.division:
                accion = "dividir";
                break;
            case R.id.igual:
                calcula = "resultado";
                break;
            case R.id.borra:
                accion = "borrar";
                break;

        }

        if (cifra >= 0) {

            valor1 = valor1 + (String.valueOf(cifra));
            textView.setText(valor1 + ".00");

        }

        switch (accion) {

            // control = 0;

            case "borrar":
                resetearValores();
                textView.setText(valor1);
                break;
            case "sumar":
                // convertir string a int valor2 = valor1;
                break;
            case "restar":
                break;
            case "multiplicar":
                break;
            case "dividir":
                break;

        }

        // Mostramos en pantalla el valor del boton que hemos pulsado
        Toast.makeText(getApplicationContext(),"Valor: " + cifra , Toast.LENGTH_LONG).show();

    }

    private void resetearValores(){
        valor1 = "";
        cifra = 0;

    }


}


