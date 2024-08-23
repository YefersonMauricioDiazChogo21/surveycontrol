package com.questcontrol.opcionrespuesta.app;

import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class CreateOpcionRespuestaUseCase {
    private OpcionRespuestaService opcionrespuestaService;

    public CreateOpcionRespuestaUseCase(OpcionRespuestaService opcionrespuestaService){
        this.opcionrespuestaService= opcionrespuestaService;
    }

    public void execute(OpcionRespuesta opcionrespuesta){
        opcionrespuestaService.createOpcionRespuesta(opcionrespuesta);
    }
}
