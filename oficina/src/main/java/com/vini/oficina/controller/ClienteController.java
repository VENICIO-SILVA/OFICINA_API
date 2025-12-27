package com.vini.oficina.controller;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/CadastrarCliente")
    public ResponseEntity<Clientes> CadastrarCliente(@Valid @RequestBody ClientesRequestDTO dto) {
        Clientes cliente = clienteService.CadastrarCliente(dto);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("ObterClientePorID/{id}")
    public ResponseEntity<Clientes> ObterClientePorId(@Valid @PathVariable int id){
        Clientes clientes = clienteService.ObterClientePorId(id);
        return ResponseEntity.ok(clientes);
    }

    @PatchMapping("/AlterarDadosCliente/{id}")
    public ResponseEntity<Clientes> AlterarDadosCliente(@PathVariable int id, @Valid @RequestBody ClientesRequestDTO dto){
        Clientes cliente = clienteService.AlterarClientePorID(id, dto);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/ApagarCliente/{id}")
    public ResponseEntity<Clientes> ApagarCliente(@PathVariable int id, ClientesRequestDTO dto){
        Clientes clientes = clienteService.ApagarClientePorID(id,dto);

        return ResponseEntity.ok(clientes);
    }
}
