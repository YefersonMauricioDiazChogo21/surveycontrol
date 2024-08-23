package com.questcontrol.opcionrespuesta.domain.entity;

import java.sql.Timestamp;

public class OpcionRespuesta {
    private int id;
    private int valor_opcion;
    private int catalogo_id;
    private java.sql.Timestamp fecha_creacion;
    private int respuesta_padre_id;
    private int pregunta_id;
    private java.sql.Timestamp fecha_actualizacion ;
    private String tipo_componente_html;
    private String comentario_pregunta;
    private String opcion_text;
    
    public OpcionRespuesta() {
    }

    

    public OpcionRespuesta(int valor_opcion, int catalogo_id, int respuesta_padre_id, int pregunta_id,
            String tipo_componente_html, String comentario_pregunta, String opcion_text) {
        this.valor_opcion = valor_opcion;
        this.catalogo_id = catalogo_id;
        this.respuesta_padre_id = respuesta_padre_id;
        this.pregunta_id = pregunta_id;
        this.tipo_componente_html = tipo_componente_html;
        this.comentario_pregunta = comentario_pregunta;
        this.opcion_text = opcion_text;
    }



    public OpcionRespuesta(int valor_opcion, int catalogo_id, Timestamp fecha_creacion, int respuesta_padre_id,
            int pregunta_id, Timestamp fecha_actualizacion, String tipo_componente_html, String comentario_pregunta,
            String opcion_text) {
        this.valor_opcion = valor_opcion;
        this.catalogo_id = catalogo_id;
        this.fecha_creacion = fecha_creacion;
        this.respuesta_padre_id = respuesta_padre_id;
        this.pregunta_id = pregunta_id;
        this.fecha_actualizacion = fecha_actualizacion;
        this.tipo_componente_html = tipo_componente_html;
        this.comentario_pregunta = comentario_pregunta;
        this.opcion_text = opcion_text;
    }

    public OpcionRespuesta(int id, int valor_opcion, int catalogo_id, Timestamp fecha_creacion, int respuesta_padre_id,
            int pregunta_id, Timestamp fecha_actualizacion, String tipo_componente_html, String comentario_pregunta,
            String opcion_text) {
        this.id = id;
        this.valor_opcion = valor_opcion;
        this.catalogo_id = catalogo_id;
        this.fecha_creacion = fecha_creacion;
        this.respuesta_padre_id = respuesta_padre_id;
        this.pregunta_id = pregunta_id;
        this.fecha_actualizacion = fecha_actualizacion;
        this.tipo_componente_html = tipo_componente_html;
        this.comentario_pregunta = comentario_pregunta;
        this.opcion_text = opcion_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor_opcion() {
        return valor_opcion;
    }

    public void setValor_opcion(int valor_opcion) {
        this.valor_opcion = valor_opcion;
    }

    public int getCatalogo_id() {
        return catalogo_id;
    }

    public void setCatalogo_id(int catalogo_id) {
        this.catalogo_id = catalogo_id;
    }

    public java.sql.Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(java.sql.Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getRespuesta_padre_id() {
        return respuesta_padre_id;
    }

    public void setRespuesta_padre_id(int respuesta_padre_id) {
        this.respuesta_padre_id = respuesta_padre_id;
    }

    public int getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(int pregunta_id) {
        this.pregunta_id = pregunta_id;
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

    public String getComentario_pregunta() {
        return comentario_pregunta;
    }

    public void setComentario_pregunta(String comentario_pregunta) {
        this.comentario_pregunta = comentario_pregunta;
    }

    public String getOpcion_text() {
        return opcion_text;
    }

    public void setOpcion_text(String opcion_text) {
        this.opcion_text = opcion_text;
    }

    
}
