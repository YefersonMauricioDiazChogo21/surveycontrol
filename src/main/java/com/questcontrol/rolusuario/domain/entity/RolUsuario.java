package com.questcontrol.rolusuario.domain.entity;

public class RolUsuario {
    private int rol_id;
    private int usuario_id;
    
    public RolUsuario() {
    }

    public RolUsuario(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public RolUsuario(int id, int usuario_id) {
        this.rol_id = id;
        this.usuario_id = usuario_id;
    }


    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }


    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    
}
