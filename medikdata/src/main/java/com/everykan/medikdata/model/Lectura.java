package com.everykan.medikdata.model;

import java.util.Date;

public class Lectura {

    private Date fechaHora;
    private double peso;
    private double diastolica;
    private double sistolica;
    private double longitud;
    private double latitud;

    public Lectura(){

    }

    // Getter y Setter

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(double diastolica) {
        this.diastolica = diastolica;
    }

    public double getSistolica() {
        return sistolica;
    }

    public void setSistolica(double sistolica) {
        this.sistolica = sistolica;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    // toString

    @Override
    public String toString() {
        return "Lectura{" +
                "fechaHora=" + fechaHora +
                ", peso=" + peso +
                ", diastolica=" + diastolica +
                ", sistolica=" + sistolica +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }
}
