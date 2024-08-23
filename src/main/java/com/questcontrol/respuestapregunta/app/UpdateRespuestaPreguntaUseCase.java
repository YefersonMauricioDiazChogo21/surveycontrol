package com.questcontrol.respuestapregunta.app;

import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class UpdateRespuestaPreguntaUseCase {
    private RespuestaPreguntaService respuestaPreguntaService;

    public UpdateRespuestaPreguntaUseCase(RespuestaPreguntaService respuestaPreguntaService){
        this.respuestaPreguntaService=respuestaPreguntaService;
    }

    public void execute(RespuestaPregunta respuestaPregunta,int id){
        respuestaPreguntaService.updateRespuestaPregunta(respuestaPregunta,id);
    }
}
