package com.questcontrol.opcionsubrespuesta.domain.entity;

import java.sql.Timestamp;

public class OpcionSubRespuesta {
    private int id;
    private int numero_subrespuesta;
    private java.sql.Timestamp fecha_creacion;
    private int opcion_respuesta_id;
    private java.sql.Timestamp fecha_actualizacion ;
    private String tipo_componente_html;
    private String subrespueta_text;
    
    public OpcionSubRespuesta() {
    }

    public OpcionSubRespuesta(int numero_subrespuesta, Timestamp fecha_creacion, int opcion_respuesta_id,
            Timestamp fecha_actualizacion, String tipo_componente_html, String subrespueta_text) {
        this.numero_subrespuesta = numero_subrespuesta;
        this.fecha_creacion = fecha_creacion;
        this.opcion_respuesta_id = opcion_respuesta_id;
        this.fecha_actualizacion = fecha_actualizacion;
        this.tipo_componente_html = tipo_componente_html;
        this.subrespueta_text = subrespueta_text;
    }

    public OpcionSubRespuesta(int id, int numero_subrespuesta, Timestamp fecha_creacion, int opcion_respuesta_id,
            Timestamp fecha_actualizacion, String tipo_componente_html, String subrespueta_text) {
        this.id = id;
        this.numero_subrespuesta = numero_subrespuesta;
        this.fecha_creacion = fecha_creacion;
        this.opcion_respuesta_id = opcion_respuesta_id;
        this.fecha_actualizacion = fecha_actualizacion;
        this.tipo_componente_html = tipo_componente_html;
        this.subrespueta_text = subrespueta_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_subrespuesta() {
        return numero_subrespuesta;
    }

    public void setNumero_subrespuesta(int numero_subrespuesta) {
        this.numero_subrespuesta = numero_subrespuesta;
    }

    public java.sql.Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(java.sql.Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getOpcion_respuesta_id() {
        return opcion_respuesta_id;
    }

    public void setOpcion_respuesta_id(int opcion_respuesta_id) {
        this.opcion_respuesta_id = opcion_respuesta_id;
    }

    public java.sql.Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(java.sql.Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getTipo_componente_html() {
        return tipo_componente_html;
    }

    public void setTipo_componente_html(String tipo_componente_html) {
        this.tipo_componente_html = tipo_componente_html;
    }

    public String getSubrespueta_text() {
        return subrespueta_text;
    }

    public void setSubrespueta_text(String subrespueta_text) {
        this.subrespueta_text = subrespueta_text;
    }

    
}
