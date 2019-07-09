package com.everykan.resthelloworld2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.everykan.resthelloworld2.model.Camarero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CamareroActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_camareros);

        textViewResult = (TextView) findViewById(R.id.idTextViewCamareros);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Camarero>> call = jsonPlaceHolderApi.getCamareros();

        call.enqueue(new Callback<List<Camarero>>() {

            @Override
            public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Camarero> camareros = response.body();

                for(Camarero camarero: camareros){
                    String content = "\n";
                    content += "ID: " + camarero.getId() + "\n";
                    content += "Nombre: " + camarero.getNombre() + "\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {

            }
        });

    }

}
