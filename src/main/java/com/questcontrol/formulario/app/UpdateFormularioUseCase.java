package com.questcontrol.formulario.app;

import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulario.domain.service.FormularioService;

public class UpdateFormularioUseCase {
     private FormularioService formularioService;

    public UpdateFormularioUseCase(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    public void execute(Formulario formulario,int id){
        formularioService.updateFormulario(formulario,id);
    }
}
