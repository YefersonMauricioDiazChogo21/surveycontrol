package com.questcontrol.pregunta.app;

import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;

public class CreatePreguntaUseCase {
    private PreguntaService preguntaService;

    public CreatePreguntaUseCase(PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    public void execute(Pregunta Pregunta){
        preguntaService.createPregunta(Pregunta);
    }
}
