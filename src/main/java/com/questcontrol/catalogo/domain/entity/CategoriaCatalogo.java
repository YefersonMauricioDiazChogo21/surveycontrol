package com.questcontrol.catalogo.domain.entity;

import java.security.Timestamp;

public class CategoriaCatalogo {
    private int id;
    private Timestamp fecha_creacion;
    private Timestamp fecha_actualizacion ;
    private String nombre;

    public CategoriaCatalogo() {
    }
    
    public CategoriaCatalogo(Timestamp fecha_creacion, Timestamp fecha_actualizacion, String nombre) {
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.nombre = nombre;
    }

    public CategoriaCatalogo(int id, Timestamp fecha_creacion, Timestamp fecha_actualizacion, String nombre) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
