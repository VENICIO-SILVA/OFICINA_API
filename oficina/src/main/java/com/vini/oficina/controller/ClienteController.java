package com.vini.oficina.controller;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.model.entitys.Clientes;
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
}
