package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Comp;
import br.univille.projetinventarioweb.repository.CompRepository;
import br.univille.projetinventarioweb.service.CompService;
@Service
public class CompServiceImpl implements CompService{
    
    @Autowired
    private CompRepository repository;

    @Override
    public List<Comp> getAll() {
        return repository.findAll();

    }

    @Override
    public Comp save(Comp comp) {
        repository.save(comp);
        return comp;
    }

    @Override
    public Comp delete(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
     }
    

    @Override
    public Comp getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            repository.deleteById(id);
            return retorno.get();
        }
        return null;
    }
    
}
