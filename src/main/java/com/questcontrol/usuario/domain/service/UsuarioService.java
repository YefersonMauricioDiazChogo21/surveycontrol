package com.questcontrol.usuario.domain.service;

import java.util.Optional;
import java.util.List;

import com.questcontrol.usuario.domain.entity.Usuario;

public interface UsuarioService {

    void createusuario (Usuario usuario);
    Usuario deleteusuario (int id);
    void updateusuario (Usuario usuario,int id);
    Optional<Usuario> findusuariobyid (int id);
    List<Usuario> findallusuarios();

}
