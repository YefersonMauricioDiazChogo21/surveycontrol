package com.questcontrol.rolusuario.app;

import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;
public class CreateRolUsuarioUseCase {
    private RolUsuarioService rolusuarioservice;

    public CreateRolUsuarioUseCase(RolUsuarioService rolusuarioservice){
        this.rolusuarioservice = rolusuarioservice;
    }

    public void execute(RolUsuario rolusuario){
        rolusuarioservice.createRolUsuario(rolusuario);
    }
}
