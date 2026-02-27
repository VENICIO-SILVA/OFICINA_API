package com.vini.oficina.dto.response;

import com.vini.oficina.model.entities.Clientes;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;
    private String dataCadastro;
    private String dataAtualizacao;
    private List<CarrosResponseDTO> carros; // lista de carros já convertida para DTO

    public ClienteResponseDTO() {}

    public ClienteResponseDTO(Clientes cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.cpf = cliente.getCpf();

        // ✅ Proteção contra null
        this.dataCadastro = cliente.getData_cadastro() != null
                ? cliente.getData_cadastro().toString()
                : null;

        this.dataAtualizacao = cliente.getData_atualizacao() != null
                ? cliente.getData_atualizacao().toString()
                : null;

        this.carros = cliente.getCarros() != null
                ? cliente.getCarros()
                .stream()
                .map(CarrosResponseDTO::new)
                .collect(Collectors.toList())
                : List.of();
    }

    // Getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(String dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public List<CarrosResponseDTO> getCarros() { return carros; }
    public void setCarros(List<CarrosResponseDTO> carros) { this.carros = carros; }
}