package com.questcontrol.capitulo.app;

import java.util.List;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;


public class FindAllCapitulosUseCase {
    private CapituloService capituloService;

    public FindAllCapitulosUseCase(CapituloService capituloService){
        this.capituloService = capituloService;
    }

    public List<Capitulo> execute(){
        return capituloService.findAllCapitulos();
    }
}
