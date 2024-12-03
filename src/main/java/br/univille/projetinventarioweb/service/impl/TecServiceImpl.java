package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.projetinventarioweb.entity.Tec;
import br.univille.projetinventarioweb.repository.TecRepository;
import br.univille.projetinventarioweb.service.TecService;

@Service
public class TecServiceImpl implements TecService{

    @Autowired
    private TecRepository repository;

    @Override
    public Tec save(Tec tec) {
        return repository.save(tec);    }

    @Override
    public Tec GetByTec(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) 
            return retorno.get();
        return null;

    }

    @Override
    public List<Tec> getAll() {
        return repository.findAll();    }

}