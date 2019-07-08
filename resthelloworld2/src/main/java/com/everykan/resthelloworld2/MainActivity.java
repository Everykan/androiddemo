package com.everykan.resthelloworld2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonCamarero;
    private Button botonProducto;
    private Button botonPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamarero = (Button) findViewById(R.id.ListCamareros);
        botonProducto = (Button) findViewById(R.id.ListProductos);
        botonPedido = (Button) findViewById(R.id.ListPedidos);

        botonCamarero.setOnClickListener(this);
        botonPedido.setOnClickListener(this);
        botonProducto.setOnClickListener(this);

        // ver que boton se ha picado para saber que View vamos a usar


        // textViewResult = (TextView) findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    }

    @Override
    public void onClick(View v) {

        // Log.d("******* ",v.getTag().toString());
        // dependiendo del boton
        // crear un intend y hacemos startActivity



        // crear los activity

    }
}
