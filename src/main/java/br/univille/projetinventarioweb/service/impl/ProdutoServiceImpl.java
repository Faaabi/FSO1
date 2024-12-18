package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Produto;
import br.univille.projetinventarioweb.repository.ProdutoRepository;
import br.univille.projetinventarioweb.service.ProdutoService;
//aqui é a implementação da interface

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        repository.save(produto);
        return produto;
    }

    @Override
    public Produto getById(long id) {
       
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
     }
     @Override
     public Produto delete(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            repository.deleteById(id);
            return retorno.get();
        }
        return null;
    }


    }

    

