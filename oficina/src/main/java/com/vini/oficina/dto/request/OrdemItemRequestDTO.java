package com.vini.oficina.dto.request;

import java.math.BigDecimal;

public class OrdemItemRequestDTO {

    private int IdOs;

    private int IdProduto;

    private int quantidade;

    private BigDecimal PrecoUnitario;

    public int getIdOs() {
        return IdOs;
    }

    public void setIdOs(int idOs) {
        IdOs = idOs;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
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
}
