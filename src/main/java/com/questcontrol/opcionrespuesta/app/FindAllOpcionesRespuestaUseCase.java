package com.questcontrol.opcionrespuesta.app;

import java.util.List;

import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class FindAllOpcionesRespuestaUseCase {
    private OpcionRespuestaService opcionrespuestaService;

    public FindAllOpcionesRespuestaUseCase(OpcionRespuestaService opcionrespuestaService){
        this.opcionrespuestaService= opcionrespuestaService;
    }

    public List<OpcionRespuesta> execute(){
        return opcionrespuestaService.findAllOpcionesRespuesta();
    }
}
