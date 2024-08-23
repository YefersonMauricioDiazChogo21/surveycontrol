package com.questcontrol.respuestapregunta.app;

import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class CreateRespuestaPreguntaUseCase {
    private RespuestaPreguntaService respuestaPreguntaService;

    public CreateRespuestaPreguntaUseCase(RespuestaPreguntaService respuestaPreguntaService){
        this.respuestaPreguntaService=respuestaPreguntaService;
    }

    public void execute(RespuestaPregunta respuestaPregunta){
        respuestaPreguntaService.createRespuestaPregunta(respuestaPregunta);
    }
}
