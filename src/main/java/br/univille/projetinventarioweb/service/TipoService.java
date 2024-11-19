package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Tipo;


public interface TipoService {
    Tipo save(Tipo tipo);
    Tipo getByTipo(long id);
    List<Tipo>getAll();
}

