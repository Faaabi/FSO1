package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Tec;
import br.univille.projetinventarioweb.entity.Tensao;

@Repository
public interface TensaoRepository extends JpaRepository<Tensao,Long>  {

    
}
