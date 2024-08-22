package com.questcontrol.rolusuario.app;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;

public class UpdateRolUsuarioUseCase {
    private RolUsuarioService rolUsuarioService;

    public UpdateRolUsuarioUseCase(RolUsuarioService rolUsuarioService){
        this.rolUsuarioService = rolUsuarioService;
    }

    public void execute(RolUsuario rolusuario,int id){
        rolUsuarioService.updateRolUsuario(rolusuario,id);
    }
}
