package br.univille.projetinventarioweb.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length = 1000)
    private String pn;

    @Column(length = 1000)
    private String modelo;

    @Column(length =  1000)
    private String marca;

 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }
  
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Tensao tensao;


    public Tensao getTensao() {
        return tensao;
    }

    public void setTensao(Tensao tensao) {
        this.tensao = tensao;
    }
    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Tcomp tcomp;

    public Tcomp getTcomp() {
        return tcomp;
    }

    public void setTcomp(Tcomp tcomp) {
        this.tcomp = tcomp;
    }
    
}
