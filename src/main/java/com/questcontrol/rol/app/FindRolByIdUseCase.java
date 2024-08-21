package com.questcontrol.rol.app;

import java.util.Optional;

import com.questcontrol.rol.domain.service.RolService;
import com.questcontrol.rol.domain.entity.Rol;

public class FindRolByIdUseCase {
    private RolService rolService;

    public FindRolByIdUseCase(RolService rolService){
        this.rolService = rolService;
    }
    public Optional<Rol> execute(int id){
        return rolService.findRolById(id);
    }
}
