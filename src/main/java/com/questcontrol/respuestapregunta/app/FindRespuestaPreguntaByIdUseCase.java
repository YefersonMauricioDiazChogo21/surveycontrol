package com.questcontrol.respuestapregunta.app;

import java.util.Optional;

import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class FindRespuestaPreguntaByIdUseCase {
    private RespuestaPreguntaService respuestaPreguntaService;

    public FindRespuestaPreguntaByIdUseCase(RespuestaPreguntaService respuestaPreguntaService){
        this.respuestaPreguntaService=respuestaPreguntaService;
    }

    public Optional<RespuestaPregunta> execute(int id){
        return respuestaPreguntaService.findRespuestaPreguntaById(id);
    }
}
