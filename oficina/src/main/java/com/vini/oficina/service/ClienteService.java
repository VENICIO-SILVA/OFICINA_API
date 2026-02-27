package com.vini.oficina.service;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.dto.response.ClienteResponseDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorie clienteRepositorie;

    // ✅ Cadastrar Cliente já retorna DTO
    public ClienteResponseDTO cadastrarCliente(ClientesRequestDTO dto) {
        if (clienteRepositorie.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já existente");
        }

        Clientes cliente = new Clientes();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        cliente.setData_cadastro(new Timestamp(System.currentTimeMillis()));

        cliente = clienteRepositorie.save(cliente);

        return new ClienteResponseDTO(cliente);
    }

    // ✅ Buscar Cliente por ID ou Nome retorna DTO
    public List<ClienteResponseDTO> obterClientePorId(String nome, Integer id) {
        List<Clientes> clientes;

        if (id != null) {
            clientes = clienteRepositorie.findById(id)
                    .map(List::of)
                    .orElse(List.of());
        } else if (nome != null && !nome.isEmpty()) {
            clientes = clienteRepositorie.findByNomeContainingIgnoreCase(nome);
        } else {
            clientes = clienteRepositorie.findAll();
        }

        return clientes.stream()
                .map(ClienteResponseDTO::new)
                .collect(Collectors.toList());
    }


    public ClienteResponseDTO alterarClientePorID(int id, ClientesRequestDTO dto) {
        Clientes cliente = clienteRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        cliente.setData_atualizacao(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))));

        cliente = clienteRepositorie.save(cliente);

        return new ClienteResponseDTO(cliente);
    }

    // ✅ Apagar Cliente
    public void apagarClientePorID(int id) {
        Clientes cliente = clienteRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        clienteRepositorie.delete(cliente);
    }
}