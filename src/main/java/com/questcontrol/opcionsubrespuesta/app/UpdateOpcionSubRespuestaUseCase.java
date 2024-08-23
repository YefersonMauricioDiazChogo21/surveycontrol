package com.questcontrol.opcionsubrespuesta.app;

import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class UpdateOpcionSubRespuestaUseCase {
    private OpcionSubRespuestaService opcionSubRespuestaService;

    public UpdateOpcionSubRespuestaUseCase(OpcionSubRespuestaService opcionSubRespuestaService){
        this.opcionSubRespuestaService=opcionSubRespuestaService;
    }

    public void execute(OpcionSubRespuesta opcionSubRespuesta,int id){
        opcionSubRespuestaService.updateOpcionSubRespuesta(opcionSubRespuesta,id);
    }
}
