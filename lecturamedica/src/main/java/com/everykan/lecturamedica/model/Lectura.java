package com.everykan.lecturamedica.model;

// implementar el intereface serializable
// objeto serializable, es un objeto que puede abandonar la memoria
// para poder enviarse en la red via ftp, convertirse en un valor...

import java.io.Serializable;
import java.util.Date;

public class Lectura implements Serializable {

    // atributos - instancias

    private Integer codigo;
    private Date fechaHora;
    private double peso;
    private double distolica;
    private double sistolica;
    private double longitud;
    private double latitud;

    public Lectura() {

    }

    public Lectura(Date fechaHora, double peso, double distolica, double sistolica) {

        this.fechaHora = fechaHora;
        this.peso = peso;
        this.distolica = distolica;
        this.sistolica = sistolica;

    }

    public Lectura(Date fechaHora, double peso, double distolica, double sistolica, double longitud, double latitud) {

        this.fechaHora = fechaHora;
        this.peso = peso;
        this.distolica = distolica;
        this.sistolica = sistolica;
        this.longitud = longitud;
        this.latitud = latitud;

    }

    // generamos getter y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

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

    public double getDistolica() {
        return distolica;
    }

    public void setDistolica(double distolica) {
        this.distolica = distolica;
    }

    public double getSistolica() { return sistolica; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lectura lectura = (Lectura) o;

        return codigo != null ? codigo.equals(lectura.codigo) : lectura.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    @Override
    public String toString() {

        return "Lectura{" +
                "codigo=" + codigo +
                ", fechaHora=" + fechaHora +
                ", peso=" + peso +
                ", distolica=" + distolica +
                ", sistolica=" + sistolica +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                '}';

    }
}
