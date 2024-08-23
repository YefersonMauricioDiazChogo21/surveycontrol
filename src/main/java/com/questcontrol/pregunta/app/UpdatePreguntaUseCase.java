package com.questcontrol.pregunta.app;

import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;

public class UpdatePreguntaUseCase {
    private PreguntaService preguntaService;

    public UpdatePreguntaUseCase(PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    public void execute(Pregunta pregunta,int id){
        preguntaService.updatePregunta(pregunta,id);
    }
}
