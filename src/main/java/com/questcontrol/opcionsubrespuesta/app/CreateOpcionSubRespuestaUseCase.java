package com.questcontrol.opcionsubrespuesta.app;

import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class CreateOpcionSubRespuestaUseCase {
    private OpcionSubRespuestaService opcionSubRespuestaService;

    public CreateOpcionSubRespuestaUseCase(OpcionSubRespuestaService opcionSubRespuestaService){
        this.opcionSubRespuestaService=opcionSubRespuestaService;
    }

    public void execute(OpcionSubRespuesta opcionSubRespuesta){
        opcionSubRespuestaService.createOpcionSubRespuesta(opcionSubRespuesta);
    }
}
