package com.vini.oficina.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class OrdemServicoRequestDTO {

    private int IdCliente;

    @NotBlank(message = "informa numeroOS")
    private String NumeroOs;

    private Timestamp DataCadastro;

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

    public String getNumeroOs() {
        return NumeroOs;
    }

    public void setNumeroOs(String numeroOs) {
        NumeroOs = numeroOs;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        this.IdCliente = idCliente;
    }
}
