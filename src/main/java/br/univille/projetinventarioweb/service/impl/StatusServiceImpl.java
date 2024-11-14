package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Status;
import br.univille.projetinventarioweb.repository.StatusRepository;
import br.univille.projetinventarioweb.service.StatusService;


@Service
public class StatusServiceImpl implements StatusService{
    
    @Autowired
    private StatusRepository repository;

    @Override
    public Status save(Status status){
        return repository.save(status);
    }
    @Override
    public Status getByStatus(long id){
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }
    @Override
    public List<Status> getAll() {
        return repository.findAll();

    }
}
