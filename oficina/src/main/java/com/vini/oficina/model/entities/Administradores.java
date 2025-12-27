package com.vini.oficina.model.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Administradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adm")
    private int id;

    @Column
    private String nome;

    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String telefone;
    @Column
    private String cargo;
    @Column
    private Timestamp data_criacao;
    @Column
    private Timestamp data_atualizacao;

    public Administradores(){

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Timestamp getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Timestamp data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Timestamp getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
