package com.vini.oficina.service;

import com.vini.oficina.dto.request.OrdemServicoRequestDTO;
import com.vini.oficina.dto.response.OrdemServicoResponseDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.model.entities.OrdemServico;
import com.vini.oficina.model.entities.StatusOrdemServico;
import com.vini.oficina.model.entities.TipoOrdemServico;
import com.vini.oficina.repository.ClienteRepositorie;
import com.vini.oficina.repository.OrdemServicoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepositorie ordemServicoRepositorie;
    @Autowired
    private ClienteRepositorie clienteRepositorie;

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
        OrdemServico ordemServico = ordemServicoRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Ordem nao encontrada"));
        Clientes clientes = ordemServico.getCliente();
        OrdemServicoResponseDTO ResponseDTO = new OrdemServicoResponseDTO();

        ResponseDTO.setCliente(clientes.getNome());
        ResponseDTO.setIdCliente(clientes.getId());
        ResponseDTO.setStatus(ordemServico.getTipo().toString());
        ResponseDTO.setTipo(ordemServico.getStatus().toString());
        ResponseDTO.setID_OS(ordemServico.getId());
        ResponseDTO.setNumeroOs(ordemServico.getNumeroOS());
        ResponseDTO.setObservacoes(ordemServico.getObservacoes());
        ResponseDTO.setDataCadastro(ordemServico.getDataCadastro());
        ResponseDTO.getDataDeAtualizacao(ordemServico.getDataAtualizacao());
        ResponseDTO.setMao_de_obra(ordemServico.getMaoDeObra());

        return ResponseDTO;
    }
}
