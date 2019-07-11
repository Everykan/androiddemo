package com.everykan.resthelloworld2.model;

public class LineaPedido {

    private int cantidad;
    private double precio;

    private Producto producto;

    public LineaPedido(){

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "cantidad=" + cantidad +
                ", precio=" + precio +
                ", producto=" + producto +
                '}';
    }
}
