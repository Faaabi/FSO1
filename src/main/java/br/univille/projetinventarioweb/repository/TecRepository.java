package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projetinventarioweb.entity.Tec;

@Repository
public interface TecRepository extends JpaRepository<Tec,Long> {
    
}
