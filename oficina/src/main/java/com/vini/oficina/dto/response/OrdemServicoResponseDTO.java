package com.vini.oficina.dto.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrdemServicoResponseDTO {

    private int idOS;
    private String cliente;
    private int idCliente;
    private String observacoes;
    private String numeroOs;
    private String tipo;
    private String status;
    private Timestamp dataCadastro;
    private Timestamp dataDeAtualizacao;
    private BigDecimal maoDeObra;
    private List<OrdemItemResponseDTO> items;

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNumeroOs() {
        return numeroOs;
    }

    public void setNumeroOs(String numeroOs) {
        this.numeroOs = numeroOs;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(Timestamp dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public BigDecimal getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(BigDecimal maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public List<OrdemItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<OrdemItemResponseDTO> items) {
        this.items = items;
    }
}
