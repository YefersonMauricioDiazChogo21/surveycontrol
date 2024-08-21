package com.questcontrol.usuario.app;

import com.questcontrol.usuario.domain.service.UsuarioService;
import com.questcontrol.usuario.domain.entity.Usuario;

public class UpdateUsuarioUseCase {
    private UsuarioService usuarioService;

    public UpdateUsuarioUseCase(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario,int id){
        usuarioService.updateusuario(usuario,id);
    }
}
