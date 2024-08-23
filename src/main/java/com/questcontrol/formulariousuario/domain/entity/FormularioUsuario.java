package com.questcontrol.formulariousuario.domain.entity;

public class FormularioUsuario {
    private int id;
    private int respuesta_id;
    private int subrespuesta_id;
    private int text;
    
    public FormularioUsuario() {
    }

    public FormularioUsuario(int id, int respuesta_id, int subrespuesta_id, int text) {
        this.id = id;
        this.respuesta_id = respuesta_id;
        this.subrespuesta_id = subrespuesta_id;
        this.text = text;
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

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    
}
