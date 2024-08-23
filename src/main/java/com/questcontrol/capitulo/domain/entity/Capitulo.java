package com.questcontrol.capitulo.domain.entity;

import java.sql.Timestamp;

public class Capitulo {
    private int id;
    private java.sql.Timestamp fecha_creacion;
    private int formulario_id;
    private java.sql.Timestamp fecha_actualizacion ;
    private String numero_capitulo;
    private String titulo_capitulo;

    public Capitulo() {
    }
    

    public Capitulo(int formulario_id, String numero_capitulo, String titulo_capitulo) {
        this.formulario_id = formulario_id;
        this.numero_capitulo = numero_capitulo;
        this.titulo_capitulo = titulo_capitulo;
    }


    public Capitulo(Timestamp fecha_creacion, int formulario_id, Timestamp fecha_actualizacion,
            String numero_capitulo, String titulo_capitulo) {
        this.fecha_creacion = fecha_creacion;
        this.formulario_id = formulario_id;
        this.fecha_actualizacion = fecha_actualizacion;
        
        this.numero_capitulo = numero_capitulo;
        this.titulo_capitulo = titulo_capitulo;
    }

    public Capitulo(int id, Timestamp fecha_creacion, int formulario_id, Timestamp fecha_actualizacion,
             String numero_capitulo, String titulo_capitulo) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.formulario_id = formulario_id;
        this.fecha_actualizacion = fecha_actualizacion;
        this.numero_capitulo = numero_capitulo;
        this.titulo_capitulo = titulo_capitulo;
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

    public int getFormulario_id() {
        return formulario_id;
    }

    public void setFormulario_id(int formulario_id) {
        this.formulario_id = formulario_id;
    }

    public java.sql.Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(java.sql.Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getNumero_capitulo() {
        return numero_capitulo;
    }

    public void setNumero_capitulo(String numero_capitulo) {
        this.numero_capitulo = numero_capitulo;
    }

    public String getTitulo_capitulo() {
        return titulo_capitulo;
    }

    public void setTitulo_capitulo(String titulo_capitulo) {
        this.titulo_capitulo = titulo_capitulo;
    }
    
    
}
