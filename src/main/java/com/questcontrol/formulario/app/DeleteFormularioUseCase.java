package com.questcontrol.formulario.app;

import com.questcontrol.formulario.domain.service.FormularioService;

public class DeleteFormularioUseCase {
    private FormularioService formularioService;

    public DeleteFormularioUseCase(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    public void execute(int id){
        formularioService.deleteFormulario(id);
    }
}
