package com.questcontrol.capitulo.app;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;

public class UpdateCapituloUseCase {
    private CapituloService capituloService;

    public UpdateCapituloUseCase(CapituloService capituloService){
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulo,int id){
        capituloService.updateCapitulo(capitulo,id);
    }
}
