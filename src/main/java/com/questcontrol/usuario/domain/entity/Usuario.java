package com.questcontrol.usuario.domain.entity;

public class Usuario {
    private int id;
    private boolean habilitado;
    private String nombre_usuario;
    private String contraseña;

    
    public Usuario() {
    }

    public Usuario(int id, boolean habilitado, String nombre_usuario, String contraseña) {
        this.id = id;
        this.habilitado = habilitado;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isHabilitado() {
        return habilitado;
    }
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
