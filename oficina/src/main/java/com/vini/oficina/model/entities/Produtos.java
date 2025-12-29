package com.vini.oficina.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produtos {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String NomeProduto;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal Valor;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrdemServicoItens> ordemServicoItens;

    public List<OrdemServicoItens> getOrdemServicoItens() {
        return ordemServicoItens;
    }

    public void setOrdemServicoItens(List<OrdemServicoItens> ordemServicoItens) {
        this.ordemServicoItens = ordemServicoItens;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal valor) {
        Valor = valor;
    }
}
