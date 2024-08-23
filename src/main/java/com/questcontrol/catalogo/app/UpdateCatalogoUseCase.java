package com.questcontrol.catalogo.app;

import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class UpdateCatalogoUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public UpdateCatalogoUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public void execute(int id){
        categoriaCatalogoService.deleteCatalogo(id);
    }
}
