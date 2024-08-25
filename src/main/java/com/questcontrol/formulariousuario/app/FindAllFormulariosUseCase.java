package com.questcontrol.formulariousuario.app;

import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;
import com.questcontrol.formulario.domain.entity.Formulario;
import java.util.List;



public class FindAllFormulariosUseCase {
    private FormularioUsuarioService formularioUsuarioService;

    public FindAllFormulariosUseCase (FormularioUsuarioService formularioUsuarioService){
        this.formularioUsuarioService=formularioUsuarioService;
    }

    public List<Formulario> execute(){
        return formularioUsuarioService.findAllFormularios();
    }
}
