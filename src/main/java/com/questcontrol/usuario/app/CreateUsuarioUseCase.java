package com.questcontrol.usuario.app;

import com.questcontrol.usuario.domain.entity.Usuario;
import com.questcontrol.usuario.domain.service.UsuarioService;

public class CreateUsuarioUseCase {
    private UsuarioService usuarioservice;

    public CreateUsuarioUseCase(UsuarioService usuarioservice){
        this.usuarioservice = usuarioservice;
    }

    public void execute(Usuario usuario){
        usuarioservice.createusuario(usuario);
    }
}
