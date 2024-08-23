package com.questcontrol.formulario.app;

import java.util.List;

import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulario.domain.service.FormularioService;

public class FindAllFormulariosUseCase {
    private FormularioService formularioService;

    public FindAllFormulariosUseCase(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    public List<Formulario> execute(){
        return formularioService.findAllFormularios();
    }
}
