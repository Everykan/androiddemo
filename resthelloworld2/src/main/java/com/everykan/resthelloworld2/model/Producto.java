package com.everykan.resthelloworld2.model;

import java.util.Date;

public class Producto {

    private long codigo;
    private String nombre;
    private double precio;
    private boolean descatalogado;
    private String descripcion;
    private Date fechaAlta;

    /*
    codigo	long
    descatalogado	boolean
    descripcion	string
    fechaAlta	Date
    nombre	string
    precio	double
    */

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public boolean isDescatalogado() {
        return descatalogado;
    }

    public void setDescatalogado(boolean descatalogado) {
        this.descatalogado = descatalogado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descatalogado=" + descatalogado +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}

