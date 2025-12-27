package com.vini.oficina.service;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.repository.CarrosRepositorie;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositorie clienteRepositorie;

    @Autowired
    private CarrosRepositorie carrosRepositorie;

    public Clientes CadastrarCliente(ClientesRequestDTO dto) {
        if (clienteRepositorie.existsByEmail(dto.getEmail())) {
            System.out.println("Email ja Existente");
        }
        Clientes cliente = new Clientes();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());

        Timestamp HoraAtual = new Timestamp(System.currentTimeMillis());

        cliente.setData_cadastro(HoraAtual);

        return clienteRepositorie.save(cliente);
    }

    //todo corrigir LAZY
    public Clientes ObterClientePorId(int id) {
        Clientes cliente = clienteRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.getCarros().size();

        return cliente;

    }

    public Clientes AlterarClientePorID(int id, ClientesRequestDTO dto) {
        Clientes clienteExistente = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente não existe"));
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setCpf(dto.getCpf());
        clienteExistente.setTelefone(dto.getTelefone());
        clienteExistente.setEndereco(dto.getEndereco());
        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        clienteExistente.setData_atualizacao(Timestamp.valueOf(agora));

        clienteRepositorie.save(clienteExistente);
        return clienteExistente;
    }

    public Clientes ApagarClientePorID(int id, ClientesRequestDTO dto) {
        Clientes DeletCliente = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente Nao existe"));
        clienteRepositorie.delete(DeletCliente);

        return DeletCliente;
    }
}
