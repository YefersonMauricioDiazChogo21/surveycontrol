package com.questcontrol.rol.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.rol.domain.entity.Rol;

public interface RolService {
    void createRol (Rol rol);
    Rol deleteRol (int id);
    void updateRol(Rol rol,int id);
    Optional<Rol> findRolById (int id);
    List<Rol> findallRoles();
}
