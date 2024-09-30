package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Produto;///isso é so a interface

public interface ProdutoService {
    List<Produto> getAll();
    Produto save(Produto produto);
    Produto delete(long id);
    Produto getById(long id);
    

}
