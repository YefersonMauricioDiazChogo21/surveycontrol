package com.questcontrol.usuario.app;

import com.questcontrol.usuario.domain.service.UsuarioService;

public class DeleteUsuarioUseCase {
    private UsuarioService usuarioService;

    public DeleteUsuarioUseCase(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void execute(int id){
        usuarioService.deleteusuario(id);
    }
}
