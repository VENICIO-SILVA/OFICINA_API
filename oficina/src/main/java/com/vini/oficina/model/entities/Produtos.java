package com.vini.oficina.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @JsonIgnore
    private List<OrdemServicoItens> ordemServicoItens;

    @Column(name = "data_cadastro", nullable = false)
    private Timestamp DataCadastro;

    @Column(name = "data_atualizacao", nullable = false)
    private Timestamp DataAtualizacao;

    public Timestamp getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        DataCadastro = dataCadastro;
    }

    public Timestamp getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        DataAtualizacao = dataAtualizacao;
    }

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
