package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Localizacao;

public interface LocalizacaoSevice {
    Localizacao save(Localizacao localizacao);
    Localizacao getByLocalizacao(long id);
    List<Localizacao>getAll();
}
