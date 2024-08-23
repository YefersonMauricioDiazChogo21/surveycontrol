package com.questcontrol.opcionrespuesta.app;

import java.util.Optional;

import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class FindOpcionRespuestaByIdUseCase {
    private OpcionRespuestaService opcionrespuestaService;

    public FindOpcionRespuestaByIdUseCase(OpcionRespuestaService opcionrespuestaService){
        this.opcionrespuestaService= opcionrespuestaService;
    }

    public Optional<OpcionRespuesta> execute(int id){
        return opcionrespuestaService.findOpcionRespuestaById(id);
    }
}
