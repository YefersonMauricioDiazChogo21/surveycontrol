package com.questcontrol.capitulo.app;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;

public class CreateCapituloUseCase {
    private CapituloService capituloService;

    public CreateCapituloUseCase(CapituloService capituloService){
        this.capituloService = capituloService;
    }

    public void execute(Capitulo Capitulo){
        capituloService.createCapitulo(Capitulo);
    }
}
