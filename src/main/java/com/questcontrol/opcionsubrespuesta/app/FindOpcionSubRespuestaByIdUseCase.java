package com.questcontrol.opcionsubrespuesta.app;

import java.util.Optional;

import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class FindOpcionSubRespuestaByIdUseCase {
    private OpcionSubRespuestaService opcionSubRespuestaService;

    public FindOpcionSubRespuestaByIdUseCase(OpcionSubRespuestaService opcionSubRespuestaService){
        this.opcionSubRespuestaService=opcionSubRespuestaService;
    }

    public Optional<OpcionSubRespuesta> execute(int id){
        return opcionSubRespuestaService.findOpcionSubRespuestaById(id);
    }
}
