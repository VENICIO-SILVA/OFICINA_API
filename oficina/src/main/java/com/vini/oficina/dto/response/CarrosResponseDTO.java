package com.vini.oficina.dto.response;


import java.sql.Timestamp;

public class CarrosResponseDTO {

    private int IdCarro;

    private String modelo;

    private String marca;

    private String cor;

    private int ano;

    private String placa;

    private int IdCliente;

    private String NomeCliente;

    private Timestamp DataCadastro;

    private Timestamp DataAtualizacao;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Timestamp getDataCadastro() {
        return DataCadastro;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
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

    public int getIdCarro() {
        return IdCarro;
    }

    public void setIdCarro(int idCarro) {
        this.IdCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        this.IdCliente = idCliente;
    }
}
