package com.questcontrol.formulariousuario.domain.service;

import java.util.Optional;
import java.util.List;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;

public interface FormularioUsuarioService {
    List<Formulario> findAllFormularios(); 
    List<CategoriaCatalogo> findCategoriaCatalogoByIdForm ();
    List<Capitulo> findCapitulosByIdForm (int id);
    List<Pregunta> findPreguntasByIdForm (int id);
    List<OpcionRespuesta> findOpcionRespuestaByIdCapitulo();
    List<OpcionSubRespuesta> findOpcionesSubRespuestaoByIdCapitulo ();
}
