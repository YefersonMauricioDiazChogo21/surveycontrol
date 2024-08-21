package com.questcontrol.usuario.app;

import java.util.Optional;

import com.questcontrol.usuario.domain.entity.Usuario;
import com.questcontrol.usuario.domain.service.UsuarioService;

public class FindUsuarioByIdUseCase {
    private UsuarioService usuarioService;

    public FindUsuarioByIdUseCase(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    public Optional<Usuario> execute(int id){
        return usuarioService.findusuariobyid(id);
    }
}
