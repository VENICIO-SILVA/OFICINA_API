package com.vini.oficina.service;

import com.vini.oficina.dto.request.OrdemServicoRequestDTO;
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
    public OrdemServico GerarOrdem(int id, OrdemServicoRequestDTO dto){
        Clientes clientes = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setNumeroOS(dto.getNumeroOs());
        ordemServico.setTipo(TipoOrdemServico.ORÇAMENTO);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setClientes(clientes);

        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ordemServico.setDataCadastro(Timestamp.valueOf(agora));
        ordemServicoRepositorie.save(ordemServico);

        return ordemServico;
    }
}
