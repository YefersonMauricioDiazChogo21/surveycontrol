package com.questcontrol.formulariousuario.domain.service;

import java.util.Optional;
import java.util.List;

import com.questcontrol.formulario.domain.entity.Formulario;

public interface FormularioUsuarioService {
    List<Formulario> findAllFormularios(); 
    List<Formulario> findCategoriaCatalogoByIdForm ();
    List<Formulario> findCapitulosByIdForm ();
    List<Formulario> findByIdForm ();
    List<Formulario> findOpcionRespuestaByIdCapitulo();
    List<Formulario> findOpcionesSubRespuestaoByIdCapitulo ();
}
