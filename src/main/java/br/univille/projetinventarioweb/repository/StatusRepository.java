package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    
}

    
