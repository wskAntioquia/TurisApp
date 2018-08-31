package com.example.worldskills.turisapp.models;

import java.io.Serializable;

public class Sitio implements Serializable {
    private String nombre;
    private String descripcion_corta;
    private String ubicacion;
    private String descripcion;
    private String latitud;
    private String longitud;
    private int imagen;

    public Sitio() {
    }

    public Sitio(String nombre, String descripcion_corta, String ubicacion, String descripcion, String latitud, String longitud, int imagen) {
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
