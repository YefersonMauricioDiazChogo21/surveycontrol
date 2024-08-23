package com.questcontrol.catalogo.app;

import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class CreateCatalogoUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public CreateCatalogoUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public void execute(CategoriaCatalogo categoriaCatalogo){
        categoriaCatalogoService.createCatalogo(categoriaCatalogo);
    }
}
