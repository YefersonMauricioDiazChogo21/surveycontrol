package com.questcontrol.rol.app;

import com.questcontrol.rol.domain.entity.Rol;
import com.questcontrol.rol.domain.service.RolService;


public class UpdateRolUseCase {
    private RolService rolService;

    public UpdateRolUseCase(RolService rolService){
        this.rolService = rolService;
    }

    public void execute(Rol rol,int id){
        rolService.updateRol(rol,id);
    }
}
