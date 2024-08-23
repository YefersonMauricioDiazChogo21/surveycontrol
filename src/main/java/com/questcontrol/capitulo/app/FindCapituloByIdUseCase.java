package com.questcontrol.capitulo.app;

import java.util.Optional;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;

public class FindCapituloByIdUseCase {
    private CapituloService capituloService;

    public FindCapituloByIdUseCase(CapituloService capituloService){
        this.capituloService = capituloService;
    }

    public Optional<Capitulo> execute(int id){
        return capituloService.findCapituloById(id);
    }
}
