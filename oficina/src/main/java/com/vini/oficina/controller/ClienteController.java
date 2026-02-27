package com.vini.oficina.controller;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.dto.response.ClienteResponseDTO;
import com.vini.oficina.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes") // ✅ use plural e padrão REST
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/Cadastrar")
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClientesRequestDTO dto) {
        ClienteResponseDTO cliente = clienteService.cadastrarCliente(dto);
        return ResponseEntity.ok(cliente);
    }


    @GetMapping("/BuscarCliente")
    public ResponseEntity<List<ClienteResponseDTO>> obterClientePorId(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer id) {
        List<ClienteResponseDTO> lista = clienteService.obterClientePorId(nome, id);
        return ResponseEntity.ok(lista);
    }


    @PutMapping("/Editar/{id}")
    public ResponseEntity<ClienteResponseDTO> alterarDadosCliente(@PathVariable int id,
                                                                  @Valid @RequestBody ClientesRequestDTO dto) {
        ClienteResponseDTO cliente = clienteService.alterarClientePorID(id, dto);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/Excluir/{id}")
    public ResponseEntity<Void> apagarCliente(@PathVariable int id) {
        clienteService.apagarClientePorID(id);
        return ResponseEntity.noContent().build();
    }
}