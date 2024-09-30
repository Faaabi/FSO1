package br.univille.projetinventarioweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity// gera uma tabela BD


public class Produto {

    @Id //é a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um identity do id
    private long id;

    @Column(length = 1000, nullable = false) //deixa o campo obrigatorio
    private String modelo;
    
    @Column(length = 1000)
    private String obs;

    public long getId() {
        return id;    
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }   

    
}
