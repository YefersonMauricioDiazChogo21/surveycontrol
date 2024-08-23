package com.questcontrol.catalogo.domain.service;

import java.util.List;
import java.util.Optional;

import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;

public interface CategoriaCatalogoService {
    void createCatalogo (CategoriaCatalogo categoriaCatalogo);
    CategoriaCatalogo deleteCatalogo (int id);
    void updateCatalogo(CategoriaCatalogo categoriaCatalogo,int id);
    Optional<CategoriaCatalogo> findCatalogoById (int id);
    List<CategoriaCatalogo> findAllCatalogos();
}
