package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Comp;

@Repository
public interface CompRepository  extends JpaRepository<Comp, Long>{

    

    
}
