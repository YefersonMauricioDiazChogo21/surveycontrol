package com.questcontrol.usuario.app;

import java.util.List;

import com.questcontrol.usuario.domain.entity.Usuario;
import com.questcontrol.usuario.domain.service.UsuarioService;

public class FindAllUsuariosUseCase {
    private UsuarioService usuarioService;

    public FindAllUsuariosUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public List<Usuario> execute(){
        return usuarioService.findallusuarios();
    }
}
