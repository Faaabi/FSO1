package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.projetinventarioweb.entity.Tcomp;
import br.univille.projetinventarioweb.repository.TcompRepository;
import br.univille.projetinventarioweb.service.TcompService;

@Service
public class TcompServiceImpl implements TcompService {

    @Autowired
    private TcompRepository repository;

    @Override
    public Tcomp save(Tcomp Tcomp) {
        return repository.save(Tcomp);
    }

    @Override
    public Tcomp getByStatus(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) 
            return retorno.get();
        return null;
    }

    @Override
    public List<Tcomp> getAll() {
        return repository.findAll();
    }




    
}
