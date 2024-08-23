package com.questcontrol.opcionrespuesta.app;

import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class UpdateOpcionRespuestaUseCase {
    private OpcionRespuestaService opcionRespuestaService;

    public UpdateOpcionRespuestaUseCase(OpcionRespuestaService opcionRespuestaService){
        this.opcionRespuestaService =opcionRespuestaService;
    }

    public void execute(OpcionRespuesta opcionRespuesta, int id){
        opcionRespuestaService.updateOpcionRespuesta(opcionRespuesta,id);
    }
}
