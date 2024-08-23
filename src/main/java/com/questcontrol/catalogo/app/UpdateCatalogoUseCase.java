package com.questcontrol.catalogo.app;

import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class UpdateCatalogoUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public UpdateCatalogoUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public void execute(CategoriaCatalogo categoriaCatalogo, int id){
        categoriaCatalogoService.updateCatalogo(categoriaCatalogo,id);
    }
}
