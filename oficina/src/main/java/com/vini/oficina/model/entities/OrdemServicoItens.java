package com.vini.oficina.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrdemServicoItens {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal PrecoUnitario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_os")
    @JsonBackReference
    private OrdemServico ordemServico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto")
    @JsonBackReference
    private Produtos produto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}
