package com.vini.oficina.model.entitys;

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
    private Clientes clientes;

    @Column
    private Timestamp Data_Cadastro;
    @Column()
    private Timestamp Data_Atualizacao;

    public Clientes getClientes() {
        return clientes;
    }

    public Timestamp getData_Cadastro() {
        return Data_Cadastro;
    }

    public void setData_Cadastro(Timestamp data_Cadastro) {
        Data_Cadastro = data_Cadastro;
    }

    public Timestamp getData_Atualizacao() {
        return Data_Atualizacao;
    }

    public void setData_Atualizacao(Timestamp data_Atualizacao) {
        Data_Atualizacao = data_Atualizacao;
    }


    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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
