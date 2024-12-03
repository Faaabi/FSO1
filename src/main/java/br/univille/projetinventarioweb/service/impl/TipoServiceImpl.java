package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Tipo;
import br.univille.projetinventarioweb.repository.TipoRepository;
import br.univille.projetinventarioweb.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService{
    
    @Autowired
    private TipoRepository repository;

    @Override
    public Tipo save(Tipo tipo) {
        return repository.save(tipo);
    }

    @Override
    public Tipo getByTipo(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public List<Tipo> getAll() {
        return repository.findAll();
    }
    
    
}
