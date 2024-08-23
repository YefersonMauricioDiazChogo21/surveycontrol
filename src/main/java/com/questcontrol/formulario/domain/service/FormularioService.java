package com.questcontrol.formulario.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.formulario.domain.entity.Formulario;

public interface FormularioService {
    void createFormulario (Formulario formulario);
    Formulario deleteFormulario (int id);
    void updateFormulario(Formulario formulario,int id);
    Optional<Formulario> findFormularioById (int id);
    List<Formulario> findAllFormularios();
}
