package br.univille.projetinventarioweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetinventarioweb.entity.Tensao;
import br.univille.projetinventarioweb.repository.TensaoRepository;
import br.univille.projetinventarioweb.service.TensaoService;

@Service
public class TensaoServiceImpl implements TensaoService{


    @Autowired
    private TensaoRepository repository;

    @Override
    public Tensao save(Tensao tensao) {
       
        return repository.save(tensao); 
    
    }

    @Override
    public Tensao GetByTensao(long id) {
       var retorno = repository.findById(id);
        if (retorno.isPresent()) 
            return retorno.get();
        return null;
   }

    @Override
    public List<Tensao> getAll() {
        return repository.findAll();   
    }


   

    

    
}
