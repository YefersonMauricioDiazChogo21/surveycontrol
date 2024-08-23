package com.questcontrol.opcionsubrespuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;

public interface OpcionSubRespuestaService {
    void createOpcionSubRespuesta(OpcionSubRespuesta opcionSubRespuesta);
    OpcionSubRespuesta deleteOpcionSubRespuesta (int id);
    void updateOpcionSubRespuesta(OpcionSubRespuesta opcionSubRespuesta,int id);
    Optional<OpcionSubRespuesta> findOpcionSubRespuestaById (int id);
    List<OpcionSubRespuesta> findAllOpcionesSubRespuesta();
}
