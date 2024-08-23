package com.questcontrol.capitulo.app;

import com.questcontrol.capitulo.domain.service.CapituloService;

public class DeleteCapituloUseCase {
    private CapituloService capituloService;

    public DeleteCapituloUseCase(CapituloService capituloService){
        this.capituloService = capituloService;
    }

    public void execute(int id){
        capituloService.deleteCapitulo(id);
    }
}
