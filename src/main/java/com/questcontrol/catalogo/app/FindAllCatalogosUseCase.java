package com.questcontrol.catalogo.app;

import java.util.List;

import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class FindAllCatalogosUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public FindAllCatalogosUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public List<CategoriaCatalogo> execute(){
        return categoriaCatalogoService.findAllCatalogos();
    }
}
