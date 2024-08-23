package com.questcontrol.catalogo.domain.entity;


public class CategoriaCatalogo {
    private int id;
    private java.sql.Timestamp fecha_creacion;
    private java.sql.Timestamp fecha_actualizacion ;
    private String nombre;

    public CategoriaCatalogo() {
    }

    public CategoriaCatalogo(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaCatalogo(java.sql.Timestamp fecha_creacion, java.sql.Timestamp fecha_actualizacion, String nombre) {
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.nombre = nombre;
    }

    public CategoriaCatalogo(int id, java.sql.Timestamp fechaCreacion, java.sql.Timestamp fechaActualizacion, String nombre) {
        this.id = id;
        this.fecha_creacion = fechaCreacion;
        this.fecha_actualizacion = fechaActualizacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
