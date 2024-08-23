package com.questcontrol.catalogo.app;

import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class DeleteCatalogoUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public DeleteCatalogoUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public void execute(int id){
        categoriaCatalogoService.deleteCatalogo(id);
    }
}
