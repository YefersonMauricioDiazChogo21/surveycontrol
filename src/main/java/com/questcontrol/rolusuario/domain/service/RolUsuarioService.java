package com.questcontrol.rolusuario.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;

public interface RolUsuarioService {
    void createRolUsuario (RolUsuario rolusuario);
    RolUsuario deleteRolusuario (int id);
    void updateRolusuario(RolUsuario rol,int id);
    Optional<RolUsuario> findRolusuarioById (int id);
    List<RolUsuario> findallRolesUsuario();
}
