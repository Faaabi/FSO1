package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Tcomp;


@Repository
public interface TcompRepository extends JpaRepository<Tcomp, Long>{
    
}
