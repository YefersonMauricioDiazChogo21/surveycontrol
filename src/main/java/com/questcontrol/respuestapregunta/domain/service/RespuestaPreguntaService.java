package com.questcontrol.respuestapregunta.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;

public interface RespuestaPreguntaService {
    void createRespuestaPregunta(RespuestaPregunta respuestaPregunta);
    RespuestaPregunta deleteRespuestaPregunta (int id);
    void updateRespuestaPregunta(RespuestaPregunta respuestaPregunta,int id);
    Optional<RespuestaPregunta> findRespuestaPreguntaById (int id);
    List<RespuestaPregunta> findAllRespuestasPregunta();
}
