package com.questcontrol.rolusuario.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;

public interface RolUsuarioService {
    void createRolUsuario (RolUsuario rolusuario);
    RolUsuario deleteRolUsuario (int id);
    void updateRolUsuario(RolUsuario rol,int id);
    Optional<RolUsuario> findRolUsuarioById (int id);
    List<RolUsuario> findallRolesUsuario();
}
