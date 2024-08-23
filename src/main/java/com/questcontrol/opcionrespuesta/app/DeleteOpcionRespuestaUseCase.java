package com.questcontrol.opcionrespuesta.app;

import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class DeleteOpcionRespuestaUseCase {
    private OpcionRespuestaService opcionRespuestaService;

    public DeleteOpcionRespuestaUseCase (OpcionRespuestaService opcionRespuestaService){
        this.opcionRespuestaService=opcionRespuestaService;
    }

    public void execute(int id){
        opcionRespuestaService.deleteOpcionRespuesta(id);
    }
}
