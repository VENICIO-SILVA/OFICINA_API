package com.vini.oficina.service;

import com.vini.oficina.dto.request.ProdutosRequestDTO;
import com.vini.oficina.dto.response.ProdutosResponseDTO;
import com.vini.oficina.model.entities.Produtos;
import com.vini.oficina.repository.ProdutosRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepositorie produtosRepositorie;

    public Produtos CadastrarProduto(ProdutosRequestDTO dto){
        Produtos produtos = new Produtos();
        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));


        produtos.setNomeProduto(dto.getNomeProduto());
        produtos.setValor(dto.getValor());
        produtos.setDataCadastro(Timestamp.valueOf(agora));

        produtosRepositorie.save(produtos);

        return produtos;

    }

    public ProdutosResponseDTO ObterProdutos(int id){
        Produtos produtos = produtosRepositorie.findById(id).orElseThrow(()-> new RuntimeException("Produto nao encontrado"));
        ProdutosResponseDTO responseDTO = new ProdutosResponseDTO();

        responseDTO.setIdProduto(produtos.getId());
        responseDTO.setNomeProduto(produtos.getNomeProduto());
        responseDTO.setValor(produtos.getValor());
        responseDTO.setDataCadastro(produtos.getDataCadastro());
        responseDTO.setDataAtualizacao(produtos.getDataAtualizacao());

        return responseDTO;
    }

    public Produtos AlterarProdutos(int id, ProdutosRequestDTO dto){
        Produtos produtos = produtosRepositorie.findById(id).orElseThrow(()-> new RuntimeException("Produto nao encontrado"));

        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

        produtos.setNomeProduto(dto.getNomeProduto());
        produtos.setValor(dto.getValor());
        produtos.setDataCadastro(produtos.getDataCadastro());
        produtos.setDataAtualizacao(Timestamp.valueOf(agora));

        produtosRepositorie.save(produtos);
        return  produtos;
    }

    public void ApagarProdutos (int id){
        Produtos produtos = produtosRepositorie.findById(id).orElseThrow(()-> new RuntimeException("Produto nao encontrado"));
        produtosRepositorie.delete(produtos);
    }
}
