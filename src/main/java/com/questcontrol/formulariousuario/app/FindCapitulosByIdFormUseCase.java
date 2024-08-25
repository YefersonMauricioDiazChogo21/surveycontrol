package com.questcontrol.formulariousuario.app;

import java.util.List;

import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;
import com.questcontrol.capitulo.domain.entity.Capitulo;

public class FindCapitulosByIdFormUseCase {
    private FormularioUsuarioService formularioUsuarioService;

    public FindCapitulosByIdFormUseCase(FormularioUsuarioService formularioUsuarioService){
        this.formularioUsuarioService=formularioUsuarioService;
    }

    public List<Capitulo> execute(int id){
    	return formularioUsuarioService.findCapitulosByIdForm(id);    }
}
