package com.vini.oficina.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "ordens_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os")
    private int id;

    @Column(name = "numero_os", nullable = false, unique = true, length = 30)
    private String numeroOS;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_os", nullable = false)
    private TipoOrdemServico tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdemServico status;

    @CreationTimestamp
    @Column(name = "data_emissao", updatable = false)
    private Timestamp dataEmissao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private Timestamp dataAtualizacao;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(String numeroOS) {
        this.numeroOS = numeroOS;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public TipoOrdemServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoOrdemServico tipo) {
        this.tipo = tipo;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public Timestamp getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Timestamp dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
