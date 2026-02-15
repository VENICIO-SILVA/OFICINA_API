package com.vini.oficina.dto.response;

import com.vini.oficina.model.entities.Carros;
import com.vini.oficina.model.entities.Clientes;
import java.sql.Timestamp;

public class CarrosResponseDTO {

    private int id;
    private String modelo;
    private String marca;
    private String cor;
    private int ano;
    private String placa;
    private int idCliente;
    private String nomeCliente;
    private Timestamp dataCadastro;
    private Timestamp dataAtualizacao;

    public CarrosResponseDTO() {}

    public CarrosResponseDTO(Carros carro) {
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.cor = carro.getCor();
        this.ano = carro.getAno();
        this.placa = carro.getPlaca();
        this.dataCadastro = carro.getData_Cadastro();
        this.dataAtualizacao = carro.getData_Atualizacao();

        Clientes cliente = carro.getCliente();
        if (cliente != null) {
            this.idCliente = cliente.getId();
            this.nomeCliente = cliente.getNome();
        }
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Timestamp getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Timestamp dataCadastro) { this.dataCadastro = dataCadastro; }

    public Timestamp getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(Timestamp dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
}