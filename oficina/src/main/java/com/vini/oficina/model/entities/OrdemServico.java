package com.vini.oficina.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "ordens_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os")
    private int Id;

    @Column(length = 255)
    private String Observacoes;

    @Column(name = "numero_os", length = 10, nullable = false, unique = true)
    private String NumeroOS;

    @Column(name = "tipo_os", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOrdemServico Tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private StatusOrdemServico Status;

    @Column(name = "data_criacao")
    private Timestamp DataCadastro;

    @Column(name = "data_atualizacao")
    private Timestamp DataAtualizacao;

    @Column(name = "valor_mao_obra", precision = 10, scale = 2, nullable = false)
    private BigDecimal maoDeObra;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Clientes cliente;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrdemServicoItens> ordemServicoItens;

    public List<OrdemServicoItens> getOrdemServicoItens() {
        return ordemServicoItens;
    }

    public void setOrdemServicoItens(List<OrdemServicoItens> ordemServicoItens) {
        this.ordemServicoItens = ordemServicoItens;
    }

    public BigDecimal getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(BigDecimal maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public String getNumeroOS() {
        return NumeroOS;
    }

    public void setNumeroOS(String numeroOS) {
        NumeroOS = numeroOS;
    }

    public TipoOrdemServico getTipo() {
        return Tipo;
    }

    public void setTipo(TipoOrdemServico tipo) {
        Tipo = tipo;
    }

    public StatusOrdemServico getStatus() {
        return Status;
    }

    public void setStatus(StatusOrdemServico status) {
        Status = status;
    }

    public Timestamp getDataCadastro() {
        return DataCadastro;
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
}
