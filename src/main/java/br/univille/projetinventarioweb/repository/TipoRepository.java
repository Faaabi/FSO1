package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo,Long> {
    
}
