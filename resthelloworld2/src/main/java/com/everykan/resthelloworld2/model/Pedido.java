package com.everykan.resthelloworld2.model;

import java.util.Date;

public class Pedido {

    private long id;
    private Date fecha;
    private int mesa;

    public Pedido(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", mesa=" + mesa +
                '}';
    }
}
