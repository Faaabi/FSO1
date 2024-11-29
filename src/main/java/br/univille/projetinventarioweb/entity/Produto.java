package br.univille.projetinventarioweb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity// gera uma tabela BD
public class Produto {

    @Id //é a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um identity do id
    private long id;

    @Column(length = 1000) //deixa o campo obrigatorio
    private String modelo;
    
    @Column     
    private String sn;

    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
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
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    public Comp comp;

    public Comp getComp() {
        return comp;
    }
    public void setComp(Comp comp) {
        this.comp = comp;
    }
    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Localizacao localizacao;

    public Localizacao getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Tec  tec;

    public Tec getTec(){
        return tec;
    }
    public void setTec(Tec tec){
        this.tec = tec;
    }

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Status status;

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Tipo tipo;

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Tipo getTipo(){
        return tipo;
    }

    public void setStatus(Tipo tipo){
        this.tipo = tipo;
    }
    
    
}
