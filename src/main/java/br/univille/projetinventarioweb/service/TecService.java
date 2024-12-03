package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Tec;

public interface TecService {
    Tec save(Tec tec);
    Tec GetByTec(long id);
    List<Tec>getAll();
    
}
