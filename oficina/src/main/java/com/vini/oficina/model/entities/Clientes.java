package com.vini.oficina.model.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Clientes {

    @Id
    @Column(name = "id_cliente")
    private int id;

    private String nome;

    private String email;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    private String telefone;

    private String endereco;

    private Timestamp data_cadastro;

    private Timestamp data_atualizacao;
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    //evita loop de serialização
    @JsonManagedReference //lado dono
    private List<Carros> carros;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdemServico> ordemServico;

    public List<OrdemServico> getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(List<OrdemServico> ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<Carros> getCarros() {
        return carros;
    }

    public void setCarros(List<Carros> carros) {
        this.carros = carros;
    }

    public Timestamp getData_cadastro() {
        return data_cadastro;
    }

    public Timestamp getData_atualizacao() {
        return data_atualizacao;
    }


    public void setData_cadastro(Timestamp data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setData_atualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
