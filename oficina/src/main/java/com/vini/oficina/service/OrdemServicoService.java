package com.vini.oficina.service;

import com.vini.oficina.dto.request.OrdemServicoRequestDTO;
import com.vini.oficina.dto.response.OrdemItemResponseDTO;
import com.vini.oficina.dto.response.OrdemServicoResponseDTO;
import com.vini.oficina.model.entities.*;
import com.vini.oficina.repository.ClienteRepositorie;
import com.vini.oficina.repository.OrdemItemRepositorie;
import com.vini.oficina.repository.OrdemServicoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepositorie ordemServicoRepositorie;
    @Autowired
    private ClienteRepositorie clienteRepositorie;

    @Autowired
    private OrdemItemRepositorie ordemItemRepositorie;

    public OrdemServico GerarOrdem(int id, OrdemServicoRequestDTO dto) {
        Clientes clientes = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        OrdemServico ordemServico = new OrdemServico();
        OrdemServicoResponseDTO ResponseDTO = new OrdemServicoResponseDTO();

        ordemServico.setNumeroOS(dto.getNumeroOs());
        ordemServico.setTipo(TipoOrdemServico.ORÇAMENTO);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setCliente(clientes);
        ordemServico.setMaoDeObra(dto.getMaoDeObra());

        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ordemServico.setDataCadastro(Timestamp.valueOf(agora));
        ordemServicoRepositorie.save(ordemServico);


        return ordemServico;
    }

    public OrdemServicoResponseDTO ObterOrdemServico(int id) {
        OrdemServico ordemServico = ordemServicoRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));

        Clientes cliente = ordemServico.getCliente();

        OrdemServicoResponseDTO response = new OrdemServicoResponseDTO();

        response.setIdOS(ordemServico.getId());
        response.setNumeroOs(ordemServico.getNumeroOS());
        response.setTipo(ordemServico.getTipo().toString());
        response.setStatus(ordemServico.getStatus().toString());
        response.setObservacoes(ordemServico.getObservacoes());
        response.setDataCadastro(ordemServico.getDataCadastro());
        response.setDataDeAtualizacao(ordemServico.getDataAtualizacao());
        response.setMaoDeObra(ordemServico.getMaoDeObra());

        response.setCliente(cliente.getNome());
        response.setIdCliente(cliente.getId());


        List<OrdemItemResponseDTO> itensDTO = ordemServico.getOrdemServicoItens().stream().map(item -> {
                    OrdemItemResponseDTO dto = new OrdemItemResponseDTO();
                    dto.setIdProduto(item.getId());
                    dto.setQuantidade(item.getQuantidade());
                    dto.setPrecoUnitario(item.getPrecoUnitario());
                    dto.setNomeProduto(item.getProduto().getNomeProduto());
                    dto.setQuantidade(item.getQuantidade());
                    return dto;
                })
                .toList();

        response.setItems(itensDTO);

        return response;
    }
}
