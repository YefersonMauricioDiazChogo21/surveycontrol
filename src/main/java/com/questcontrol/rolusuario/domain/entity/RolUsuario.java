package com.questcontrol.rolusuario.domain.entity;

public class RolUsuario {
    private int id;
    private int usuario_id;
    
    public RolUsuario() {
    }

    public RolUsuario(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public RolUsuario(int id, int usuario_id) {
        this.id = id;
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    
}
