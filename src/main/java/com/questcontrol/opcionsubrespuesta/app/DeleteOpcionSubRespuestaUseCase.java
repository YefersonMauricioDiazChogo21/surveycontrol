package com.questcontrol.opcionsubrespuesta.app;

import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class DeleteOpcionSubRespuestaUseCase {
    private OpcionSubRespuestaService opcionSubRespuestaService;

    public DeleteOpcionSubRespuestaUseCase(OpcionSubRespuestaService opcionSubRespuestaService){
        this.opcionSubRespuestaService=opcionSubRespuestaService;
    }

    public void execute(int id){
        opcionSubRespuestaService.deleteOpcionSubRespuesta(id);
    }
}
