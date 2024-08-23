package com.questcontrol.formulario.domain.entity;

import java.sql.Timestamp;

public class Formulario {
    private int id;
    private java.sql.Timestamp fecha_creacion;
    private java.sql.Timestamp fecha_actualizacion ;
    private String descripcion;
    private String nombre;
    
    public Formulario() {
    }

    public Formulario(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Formulario(Timestamp fecha_creacion, Timestamp fecha_actualizacion, String descripcion, String nombre) {
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Formulario(int id, Timestamp fecha_creacion, Timestamp fecha_actualizacion, String descripcion,
            String nombre) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(java.sql.Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public java.sql.Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(java.sql.Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
