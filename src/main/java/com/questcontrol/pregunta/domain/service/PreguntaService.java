package com.questcontrol.pregunta.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.pregunta.domain.entity.Pregunta;

public interface PreguntaService {
    void createPregunta (Pregunta pregunta);
    Pregunta deletePregunta (int id);
    void updatePregunta(Pregunta pregunta,int id);
    Optional<Pregunta> findPreguntaById (int id);
    List<Pregunta> findAllPreguntas();
}
