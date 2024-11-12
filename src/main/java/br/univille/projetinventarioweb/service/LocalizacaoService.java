package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Localizacao;

public interface LocalizacaoService {
    Localizacao save(Localizacao localizacao);
    Localizacao getByLocalizacao(long id);
    List<Localizacao>getAll();
}
