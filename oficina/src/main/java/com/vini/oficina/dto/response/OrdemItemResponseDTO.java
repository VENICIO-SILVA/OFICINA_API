package com.vini.oficina.dto.response;

import java.math.BigDecimal;

public class OrdemItemResponseDTO {

    private int idProduto;
    private String nomeProduto;
    private BigDecimal precoUnitario;
    private int quantidade;

    public int getIdProduto() {
        return idProduto;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

}
