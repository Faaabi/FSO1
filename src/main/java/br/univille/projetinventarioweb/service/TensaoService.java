package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Tensao;


public interface TensaoService {
    Tensao save(Tensao tensao);
    Tensao GetByTensao(long id);
    List<Tensao>getAll();
    
}
