package com.questcontrol.rol.app;

import com.questcontrol.rol.domain.service.RolService;
import com.questcontrol.rol.domain.entity.Rol;


public class CreateRolUseCase {
    private RolService rolService;

    public CreateRolUseCase(RolService rolService){
        this.rolService = rolService;
    }

    public void execute(Rol rol){
        rolService.createRol(rol);
    }
}
