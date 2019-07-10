package com.everykan.resthelloworld2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.everykan.resthelloworld2.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);

        textViewResult = (TextView) findViewById(R.id.idTextViewProductos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Producto>> call = jsonPlaceHolderApi.getProductos();

        call.enqueue(new Callback<List<Producto>>() {

            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Producto> productos = response.body();

                for (Producto producto : productos) {

                    String content = "\n";
                    content += "Categoria :" + producto.getCategoria() + "\n";
                    content += "Codigo :" + producto.getCodigo() + "\n";
                    content += "Nombre :" + producto.getNombre() + "\n";
                    content += "Precio :" + producto.getPrecio() + "\n";
                    content += "Descatalogado :" + producto.isDescatalogado() + "\n";
                    content += "Descripción :" + producto.getDescripcion() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });

    }
}
