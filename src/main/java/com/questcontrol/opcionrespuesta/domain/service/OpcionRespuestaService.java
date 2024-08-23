package com.questcontrol.opcionrespuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;

public interface OpcionRespuestaService {
    void createOpcionRespuesta (OpcionRespuesta opcionRespuesta);
    OpcionRespuesta deleteOpcionRespuesta (int id);
    void updateOpcionRespuesta(OpcionRespuesta opcionRespuesta,int id);
    Optional<OpcionRespuesta> findOpcionRespuestaById (int id);
    List<OpcionRespuesta> findAllOpcionesRespuesta();
}
