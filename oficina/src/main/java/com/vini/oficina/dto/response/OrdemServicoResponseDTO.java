package com.vini.oficina.dto.response;

import java.sql.Timestamp;

public class OrdemServicoResponseDTO {

    private int ID_OS;

    private String cliente;

    private int IdCliente;

    private String observacoes;

    private String NumeroOs;

    private String Tipo;

    private String Status;

    private Timestamp DataCadastro;

    private Timestamp DataDeAtualizacao;

    public int getID_OS() {
        return ID_OS;
    }

    public void setID_OS(int ID_OS) {
        this.ID_OS = ID_OS;
    }

    public Timestamp getDataDeAtualizacao() {
        return DataDeAtualizacao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNumeroOs() {
        return NumeroOs;
    }

    public void setNumeroOs(String numeroOs) {
        NumeroOs = numeroOs;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Timestamp getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        DataCadastro = dataCadastro;
    }

    public Timestamp getDataDeAtualizacao(Timestamp dataAtualizacao) {
        return DataDeAtualizacao;
    }

    public void setDataDeAtualizacao(Timestamp dataDeAtualizacao) {
        DataDeAtualizacao = dataDeAtualizacao;
    }
}
