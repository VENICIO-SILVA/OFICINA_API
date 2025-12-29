package com.vini.oficina.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Carros {

    @Id
    @Column(name = "id_carro")
    private int id;

    private String modelo;

    private String marca;

    private int ano;

    private String cor;

    private String placa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    @JsonBackReference//lado inverso ignorado
    private Clientes cliente;

    //todo atualizar As data para LocalDatetime
    @Column(name = "Data_Cadastro")
    private Timestamp DataCadastro;
    @Column(name = "Data_Atualizacao")
    private Timestamp DataAtualizacao;

    public Clientes getCliente() {
        return cliente;
    }

    public Timestamp getData_Cadastro() {
        return DataCadastro;
    }

    public void setData_Cadastro(Timestamp data_Cadastro) {
        DataCadastro = data_Cadastro;
    }

    public Timestamp getData_Atualizacao() {
        return DataAtualizacao;
    }

    public void setData_Atualizacao(Timestamp data_Atualizacao) {
        DataAtualizacao = data_Atualizacao;
    }


    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    //todo implementar enum marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
