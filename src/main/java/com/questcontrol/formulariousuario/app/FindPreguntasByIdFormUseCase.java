package com.questcontrol.formulariousuario.app;

import java.util.List;

import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;
import com.questcontrol.pregunta.domain.entity.Pregunta;

public class FindPreguntasByIdFormUseCase {
    private FormularioUsuarioService formularioUsuarioService;

    public FindPreguntasByIdFormUseCase(FormularioUsuarioService formularioUsuarioService){
        this.formularioUsuarioService=formularioUsuarioService;
    }

    public List<Pregunta> execute(int id){
    	return formularioUsuarioService.findPreguntasByIdForm(id);
    }
}
