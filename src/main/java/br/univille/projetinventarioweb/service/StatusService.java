package br.univille.projetinventarioweb.service;

import java.util.List;

import br.univille.projetinventarioweb.entity.Status;

public interface StatusService {
    Status save(Status status);
    Status getByStatus(long id);
    List<Status>getAll();
}
