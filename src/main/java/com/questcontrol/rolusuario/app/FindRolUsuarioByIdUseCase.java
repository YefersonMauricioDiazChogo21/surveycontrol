package com.questcontrol.rolusuario.app;

import java.util.Optional;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;

public class FindRolUsuarioByIdUseCase {
    private RolUsuarioService rolusuarioService;

    public FindRolUsuarioByIdUseCase(RolUsuarioService rolusuarioService){
        this.rolusuarioService = rolusuarioService;
    }
    public Optional<RolUsuario> execute(int id){
        return rolusuarioService.findRolUsuarioById(id);
    }
}
