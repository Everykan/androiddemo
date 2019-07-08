package com.everykan.resthelloworld2;

import com.everykan.resthelloworld2.model.Camarero;
import com.everykan.resthelloworld2.model.LineaPedido;
import com.everykan.resthelloworld2.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("camareros")
    Call<List<Camarero>> getCamareros();

    @GET("productos")
    Call<List<Producto>> getProductos();

    @GET("pedidos")
    Call<List<LineaPedido>> getPedidos();


}
