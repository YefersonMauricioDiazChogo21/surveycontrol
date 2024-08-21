package com.questcontrol.rol.app;

import java.util.List;

import com.questcontrol.rol.domain.service.RolService;
import com.questcontrol.rol.domain.entity.Rol;

public class FindAllRolesUseCase {
    private RolService rolService;

    public FindAllRolesUseCase(RolService rolService) {
        this.rolService = rolService;
    }
    
    public List<Rol> execute(){
        return rolService.findallRoles();
    }
}
