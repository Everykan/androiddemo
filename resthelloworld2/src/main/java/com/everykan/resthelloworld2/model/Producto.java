package com.everykan.resthelloworld2.model;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private String descripcion;

    /*
    [#/definitions/ProductoVOProductoVO{
categoria	string
codigo	long
descatalogado	boolean
descripcion	string
fechaAlta	Date
nombre	string
precio	double
}]
     */

    public Producto(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
