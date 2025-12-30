package com.vini.oficina.controller;

import com.vini.oficina.dto.request.ProdutosRequestDTO;
import com.vini.oficina.dto.response.ProdutosResponseDTO;
import com.vini.oficina.model.entities.Produtos;
import com.vini.oficina.service.ProdutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//todo Criar metodo Get
@RestController
@RequestMapping("/Produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService produtosService;

    @PostMapping("/CadastrarProduto")
    public ResponseEntity<Produtos> CadastrarProduto(@Valid @RequestBody ProdutosRequestDTO dto) {
        Produtos produtos = produtosService.CadastrarProduto(dto);

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("ObterProduto/{id}")
    public ResponseEntity<ProdutosResponseDTO> ObterProdutos(@PathVariable int id) {
        ProdutosResponseDTO responseDTO = produtosService.ObterProdutos(id);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/AlterarProduto/{id}")
    public ResponseEntity<Produtos> AlterProdutos(@PathVariable int id, @Valid @RequestBody ProdutosRequestDTO dto) {

        Produtos produtos = produtosService.AlterarProdutos(id, dto);
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/ApagarProduto/{id}")
    public ResponseEntity<Void> ApagarProdutos(@PathVariable int id){
        produtosService.ApagarProdutos(id);

        return ResponseEntity.noContent().build();
    }

}
