package com.questcontrol.respuestapregunta.domain.entity;

public class RespuestaPregunta {
    private int id;
    private int respuesta_id;
    private int subrespuesta_id;
    private String respuesta_text;
    
    public RespuestaPregunta() {
    }

    public RespuestaPregunta(int respuesta_id, int subrespuesta_id, String respuesta_text) {
        this.respuesta_id = respuesta_id;
        this.subrespuesta_id = subrespuesta_id;
        this.respuesta_text = respuesta_text;
    }

    public RespuestaPregunta(int id, int respuesta_id, int subrespuesta_id, String respuesta_text) {
        this.id = id;
        this.respuesta_id = respuesta_id;
        this.subrespuesta_id = subrespuesta_id;
        this.respuesta_text = respuesta_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRespuesta_id() {
        return respuesta_id;
    }

    public void setRespuesta_id(int respuesta_id) {
        this.respuesta_id = respuesta_id;
    }

    public int getSubrespuesta_id() {
        return subrespuesta_id;
    }

    public void setSubrespuesta_id(int subrespuesta_id) {
        this.subrespuesta_id = subrespuesta_id;
    }

    public String getRespuesta_text() {
        return respuesta_text;
    }

    public void setRespuesta_text(String respuesta_text) {
        this.respuesta_text = respuesta_text;
    }

    

}
