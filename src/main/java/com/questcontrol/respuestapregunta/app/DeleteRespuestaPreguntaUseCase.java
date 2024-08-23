package com.questcontrol.respuestapregunta.app;

import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class DeleteRespuestaPreguntaUseCase {
    private RespuestaPreguntaService respuestaPreguntaService;

    public DeleteRespuestaPreguntaUseCase(RespuestaPreguntaService respuestaPreguntaService){
        this.respuestaPreguntaService=respuestaPreguntaService;
    }

    public void execute(int id){
        respuestaPreguntaService.deleteRespuestaPregunta(id);
    }
}
