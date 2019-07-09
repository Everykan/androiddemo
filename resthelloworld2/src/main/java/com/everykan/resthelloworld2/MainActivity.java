package com.everykan.resthelloworld2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        //textViewResult = (TextView) findViewById(R.id.text_view_result);
        //Retrofit retrofit = new Retrofit.Builder()
        //        .baseUrl("https://pedi-gest.herokuapp.com/api/")
        //        .addConverterFactory(GsonConverterFactory.create())
        //        .build();
        // jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    }

    @Override
    public void onClick(View v) {

        // dependiendo del boton
        // crear un intend y hacemos startActivity

        Intent intent = null;

        switch (v.getTag().toString()) {

            case "1":

                intent = new Intent(this, CamareroActivity.class);
                break;

            case "2":

                break;

            case "3":

                break;
        }

        startActivity(intent);

    }
}
