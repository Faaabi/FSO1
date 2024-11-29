package br.univille.projetinventarioweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tcomp {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String tcomp;

    public String getTcomp() {
        return tcomp;
    }

    public void setTcomp(String tcomp) {
        this.tcomp = tcomp;
    }
}
