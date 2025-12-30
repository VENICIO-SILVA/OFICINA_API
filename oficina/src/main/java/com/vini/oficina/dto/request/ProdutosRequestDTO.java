package com.vini.oficina.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutosRequestDTO {

    private int id;

    @NotBlank
    private String NomeProduto;

    @NotNull
    @Positive
    private BigDecimal Valor;

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
