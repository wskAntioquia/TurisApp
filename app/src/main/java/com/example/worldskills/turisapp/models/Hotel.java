package com.example.worldskills.turisapp.models;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String nombre;
    private String descripcion_corta;
    private String ubicacion;
    private String descripcion;
    private double latitud;
    private double longitud;
    private String imagen;

    public Hotel(String hotel_continental_bluedoors, String descripcion_corta, String ubicacion, String descripcion, String s, String s1, int h_hotelcontinentals) {
    }

    public Hotel(String nombre, String descripcion_corta, String ubicacion, String descripcion, double latitud, double longitud, String imagen) {
        this.nombre = nombre;
        this.descripcion_corta = descripcion_corta;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
