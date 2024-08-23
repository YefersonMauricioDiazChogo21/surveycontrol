package com.questcontrol.capitulo.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.capitulo.domain.entity.Capitulo;

public interface CapituloService {
    void createCapitulo (Capitulo capitulo);
    Capitulo deleteCapitulo (int id);
    void updateCapitulo(Capitulo capitulo,int id);
    Optional<Capitulo> findCapituloById (int id);
    List<Capitulo> findAllCapitulos();  
}
