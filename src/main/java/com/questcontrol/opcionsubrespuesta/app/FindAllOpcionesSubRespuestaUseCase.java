package com.questcontrol.opcionsubrespuesta.app;

import java.util.List;

import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class FindAllOpcionesSubRespuestaUseCase {
    private OpcionSubRespuestaService opcionSubRespuestaService;

    public FindAllOpcionesSubRespuestaUseCase(OpcionSubRespuestaService opcionSubRespuestaService){
        this.opcionSubRespuestaService=opcionSubRespuestaService;
    }

    public List<OpcionSubRespuesta> execute(){
        return opcionSubRespuestaService.findAllOpcionesSubRespuesta();
    }
}
