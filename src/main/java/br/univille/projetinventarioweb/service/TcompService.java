package br.univille.projetinventarioweb.service;

import java.util.List;
import br.univille.projetinventarioweb.entity.Tcomp;

public interface TcompService {
    Tcomp save(Tcomp Tcomp);
    Tcomp getByStatus(long id);
    List<Tcomp>getAll();
}
