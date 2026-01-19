package com.vini.oficina.controller;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.dto.response.ClienteResponseDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    //todo Alterar para devolver response
    @PostMapping("/Cadastrar")
    public ResponseEntity<Clientes> CadastrarCliente(@Valid @RequestBody ClientesRequestDTO dto) {
        Clientes cliente = clienteService.CadastrarCliente(dto);

        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/BuscarCliente/")
    public ResponseEntity<List<Clientes>> ObterClientePorId(@RequestParam(required = false) String nome, @RequestParam(required = false) Integer id){
        List<Clientes> lista  = clienteService.ObterClientePorId(nome, id);
        return ResponseEntity.ok(lista);
    }
    @PutMapping("/Editar/{id}")
    public ResponseEntity<ClienteResponseDTO> AlterarDadosCliente(@PathVariable int id, @Valid @RequestBody ClientesRequestDTO dto){
        ClienteResponseDTO cliente = clienteService.AlterarClientePorID(id, dto);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/ApagarCliente/{id}")
    public ResponseEntity<Void> ApagarCliente(@PathVariable int id){
         clienteService.ApagarClientePorID(id);

        return ResponseEntity.noContent().build();
    }
}
