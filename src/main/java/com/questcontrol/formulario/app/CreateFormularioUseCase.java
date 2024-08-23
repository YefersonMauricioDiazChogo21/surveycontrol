package com.questcontrol.formulario.app;

import com.questcontrol.formulario.domain.service.FormularioService;
import com.questcontrol.formulario.domain.entity.Formulario;;

public class CreateFormularioUseCase {
    private FormularioService formularioService;

    public CreateFormularioUseCase(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    public void execute(Formulario formulario){
        formularioService.createFormulario(formulario);
    }
}
