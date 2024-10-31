package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Localizacao;
import br.univille.projetinventarioweb.repository.LocalizacaoRepository;
import br.univille.projetinventarioweb.service.LocalizacaoSevice;


@Service
public class LocalizacaoServiceImpl implements LocalizacaoSevice {
    @Autowired
    private LocalizacaoRepository repository;


    @Override
    public Localizacao save(Localizacao localizacao) {
        return repository.save(localizacao);
    }

    @Override
    public Localizacao getByLocalizacao(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) 
            return retorno.get();
        return null;


    }

    @Override
    public List<Localizacao> getAll() {
        return repository.findAll();
    }
    
}
