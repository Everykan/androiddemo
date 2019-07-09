package com.everykan.resthelloworld2.model;

import com.google.gson.annotations.SerializedName; // gson convierte java <---> JSON

public class Camarero {

    @SerializedName("codigo")
    private long id;
    private String nombre;

    public Camarero(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Camarero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
