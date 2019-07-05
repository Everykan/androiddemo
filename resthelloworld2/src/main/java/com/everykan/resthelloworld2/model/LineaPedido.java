package com.everykan.resthelloworld2.model;

public class LineaPedido {

    /*{
        "cantidad": 0,
            "precio": 0,
            "producto": {
        "categoria": "CAFE",
                "codigo": 0,
                "descatalogado": true,
                "descripcion": "string",
                "fechaAlta": "2019-07-05T11:31:23.891Z",
                "nombre": "string",
                "precio": 0
    }*/

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
