package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetinventarioweb.entity.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


    
}
