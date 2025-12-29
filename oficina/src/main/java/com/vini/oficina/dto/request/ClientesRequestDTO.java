package com.vini.oficina.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class ClientesRequestDTO {


    @NotBlank
    private String Nome;

    @NotBlank
    @Email
    private String email;


    //todo validação foi removida para teste
    private String cpf;

    private String telefone;

    private String endereco;


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
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
