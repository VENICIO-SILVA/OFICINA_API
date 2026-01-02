package com.vini.oficina.service;

import com.vini.oficina.dto.request.OrdemItemRequestDTO;
import com.vini.oficina.dto.response.OrdemItemResponseDTO;
import com.vini.oficina.model.entities.OrdemServico;
import com.vini.oficina.model.entities.OrdemServicoItens;
import com.vini.oficina.model.entities.Produtos;
import com.vini.oficina.repository.OrdemItemRepositorie;
import com.vini.oficina.repository.OrdemServicoRepositorie;
import com.vini.oficina.repository.ProdutosRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemItemService {

    @Autowired
    private OrdemServicoRepositorie ordemServicoRepositorie;

    @Autowired
    private OrdemItemRepositorie ordemItemRepositorie;

    @Autowired
    private ProdutosRepositorie produtosRepositorie;

    public OrdemItemResponseDTO CadastrarOrdemItem(int idOs, OrdemItemRequestDTO dto) {
        OrdemServico ordemServico = ordemServicoRepositorie.findById(idOs).orElseThrow(() -> new RuntimeException("Ordem nao encontrada"));
        Produtos produtos = produtosRepositorie.findById(dto.getIdProduto()).orElseThrow(() -> new RuntimeException("produto nao encontrado"));

        OrdemServicoItens item = new OrdemServicoItens();

        item.setOrdemServico(ordemServico);
        item.setProduto(produtos);
        item.setPrecoUnitario(dto.getPrecoUnitario());
        item.setQuantidade(dto.getQuantidade());

        ordemItemRepositorie.save(item);

        OrdemItemResponseDTO response = new OrdemItemResponseDTO();
        //todo configurar retorno apenas para essa classe do numero de os
        response.setIdProduto(item.getOrdemServico().getId());
        response.setIdProduto(produtos.getId());
        response.setNomeProduto(produtos.getNomeProduto());
        response.setQuantidade(item.getQuantidade());
        response.setPrecoUnitario(item.getPrecoUnitario());


        return response;
    }
}
