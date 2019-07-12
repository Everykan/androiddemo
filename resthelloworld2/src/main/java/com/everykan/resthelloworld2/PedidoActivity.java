package com.everykan.resthelloworld2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.everykan.resthelloworld2.model.LineaPedido;
import com.everykan.resthelloworld2.model.Pedido;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedidoActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_activity_pedidos);

        textViewResult = (TextView) findViewById(R.id.idTextViewPedidos);

        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                Log.d("** getAsJsonPrimitive:", json.getAsJsonPrimitive().toString());
                long millisecons = json.getAsJsonPrimitive().getAsLong();
                return new Date(millisecons);
            }

        });

        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                long l = src.getTime();
                return new JsonPrimitive(l);
            }
        });

        Gson gson = builder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Pedido>> call = jsonPlaceHolderApi.getPedidos();

        call.enqueue(new Callback<List<Pedido>>() {

            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Pedido> pedidos = response.body();

                for(Pedido pedido: pedidos) {

                    String content = "\n";
                    content += "ID_Pedido : " + pedido.getId() + "\n";
                    content += "Fecha : " + pedido.getFecha() + "\n";
                    content += "Mesa : " + pedido.getMesa() + "\n";

                    // TODO hacer un for interno para mostrar las lineas de pedido

                    List<LineaPedido> lineasPedido = pedido.getLineasPedido();

                    for (LineaPedido lineaPedido : lineasPedido) {
                        // con esto he colocado en el content
                        content += "Producto : " + lineaPedido.getProducto().getNombre() + "\n\n";


                    }

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {

            }
        });




    }
}
