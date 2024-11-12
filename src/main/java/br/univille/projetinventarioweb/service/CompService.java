package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Comp;

public interface CompService {

    List<Comp> getAll();
    Comp save(Comp comp);
    Comp delete (long id);
    Comp getById(long id);
    
}
