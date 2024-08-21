package com.questcontrol.rol.app;

import com.questcontrol.rol.domain.service.RolService;

public class DeleteRolUseCase {
    private RolService rolService;

    public DeleteRolUseCase(RolService rolService){
        this.rolService = rolService;
    }

    public void execute(int id){
        rolService.deleteRol(id);
    }
}
