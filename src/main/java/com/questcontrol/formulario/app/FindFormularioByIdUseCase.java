package com.questcontrol.formulario.app;

import java.util.Optional;

import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulario.domain.service.FormularioService;

public class FindFormularioByIdUseCase {
    private FormularioService formularioService;

    public FindFormularioByIdUseCase(FormularioService formularioService){
        this.formularioService = formularioService;
    }

    public Optional<Formulario> execute(int id){
        return formularioService.findFormularioById(id);
    }
}
