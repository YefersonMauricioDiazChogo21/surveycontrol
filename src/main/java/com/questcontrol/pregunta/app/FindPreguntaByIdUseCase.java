package com.questcontrol.pregunta.app;

import java.util.Optional;

import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;

public class FindPreguntaByIdUseCase {
    private PreguntaService preguntaService;

    public FindPreguntaByIdUseCase(PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    public Optional<Pregunta> execute(int id){
        return preguntaService.findPreguntaById(id);
    }
}
