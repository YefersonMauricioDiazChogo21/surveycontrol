package com.questcontrol.pregunta.app;

import java.util.List;

import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;

public class FindAllPreguntasUseCase {
    private PreguntaService preguntaService;

    public FindAllPreguntasUseCase(PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    public List<Pregunta> execute(){
        return preguntaService.findAllPreguntas();
    }
}
