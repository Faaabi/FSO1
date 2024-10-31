package br.univille.projetinventarioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projetinventarioweb.entity.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao,Long>{
    
}
