package com.questcontrol.respuestapregunta.app;

import java.util.List;

import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class FindAllRespuestasPreguntaUseCase {
    private RespuestaPreguntaService respuestaPreguntaService;

    public FindAllRespuestasPreguntaUseCase(RespuestaPreguntaService respuestaPreguntaService){
        this.respuestaPreguntaService=respuestaPreguntaService;
    }

    public List<RespuestaPregunta> execute(){
        return respuestaPreguntaService.findAllRespuestasPregunta();
    }
}
