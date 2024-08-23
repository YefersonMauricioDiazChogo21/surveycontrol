package com.questcontrol.catalogo.app;


import java.util.Optional;

import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class FindCatalogoByIdUseCase {
    private CategoriaCatalogoService categoriaCatalogoService;

    public FindCatalogoByIdUseCase(CategoriaCatalogoService categoriaCatalogoService){
        this.categoriaCatalogoService = categoriaCatalogoService;
    }

    public Optional<CategoriaCatalogo> execute(int id){
        return categoriaCatalogoService.findCatalogoById(id);
    }
}
