package com.questcontrol.pregunta.domain.entity;

import java.sql.Timestamp;

public class Pregunta {
    private int id;
    private int capitulo_id;
    private java.sql.Timestamp fecha_creacion;
    private java.sql.Timestamp fecha_actualizacion ;
    private String numero_pregunta;
    private String tipo_respuesta;
    private String comentario_pregunta;
    private String texto_pregunta;

    public Pregunta() {
    }

    public Pregunta(int capitulo_id, String numero_pregunta, String tipo_respuesta, String comentario_pregunta,
            String texto_pregunta) {
        this.capitulo_id = capitulo_id;
        this.numero_pregunta = numero_pregunta;
        this.tipo_respuesta = tipo_respuesta;
        this.comentario_pregunta = comentario_pregunta;
        this.texto_pregunta = texto_pregunta;
    }

    public Pregunta(int capitulo_id, Timestamp fecha_creacion, Timestamp fecha_actualizacion, String numero_pregunta,
            String tipo_respuesta, String comentario_pregunta, String texto_pregunta) {
        this.capitulo_id = capitulo_id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.numero_pregunta = numero_pregunta;
        this.tipo_respuesta = tipo_respuesta;
        this.comentario_pregunta = comentario_pregunta;
        this.texto_pregunta = texto_pregunta;
    }

    public Pregunta(int id, int capitulo_id, Timestamp fecha_creacion, Timestamp fecha_actualizacion,
            String numero_pregunta, String tipo_respuesta, String comentario_pregunta, String texto_pregunta) {
        this.id = id;
        this.capitulo_id = capitulo_id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.numero_pregunta = numero_pregunta;
        this.tipo_respuesta = tipo_respuesta;
        this.comentario_pregunta = comentario_pregunta;
        this.texto_pregunta = texto_pregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapitulo_id() {
        return capitulo_id;
    }

    public void setCapitulo_id(int capitulo_id) {
        this.capitulo_id = capitulo_id;
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

    public String getNumero_pregunta() {
        return numero_pregunta;
    }

    public void setNumero_pregunta(String numero_pregunta) {
        this.numero_pregunta = numero_pregunta;
    }

    public String getTipo_respuesta() {
        return tipo_respuesta;
    }

    public void setTipo_respuesta(String tipo_respuesta) {
        this.tipo_respuesta = tipo_respuesta;
    }

    public String getComentario_pregunta() {
        return comentario_pregunta;
    }

    public void setComentario_pregunta(String comentario_pregunta) {
        this.comentario_pregunta = comentario_pregunta;
    }

    public String getTexto_pregunta() {
        return texto_pregunta;
    }

    public void setTexto_pregunta(String texto_pregunta) {
        this.texto_pregunta = texto_pregunta;
    }
    
    
    
}
