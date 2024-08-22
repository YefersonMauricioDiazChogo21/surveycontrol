package com.questcontrol.rolusuario.app;

import java.util.List;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;

public class FindAllRolesUsuarioUseCase {
    private RolUsuarioService rolusuarioService;

    public FindAllRolesUsuarioUseCase(RolUsuarioService rolusuarioService) {
        this.rolusuarioService = rolusuarioService;
    }
    
    public List<RolUsuario> execute(){
        return rolusuarioService.findallRolesUsuario();
    }
}
