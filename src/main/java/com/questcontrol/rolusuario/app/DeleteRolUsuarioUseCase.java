package com.questcontrol.rolusuario.app;

import com.questcontrol.rolusuario.domain.service.RolUsuarioService;

public class DeleteRolUsuarioUseCase {
     private RolUsuarioService rolusuarioservice;

    public DeleteRolUsuarioUseCase(RolUsuarioService rolusuarioservice){
        this.rolusuarioservice = rolusuarioservice;
    }

    public void execute(int id){
        rolusuarioservice.deleteRolUsuario(id);
    }
}
