package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projetinventarioweb.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    
}

    
