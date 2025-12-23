package com.vini.oficina.service;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.model.entitys.Clientes;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositorie clienteRepositorie;

    public Clientes CadastrarCliente(ClientesRequestDTO dto){
        if (clienteRepositorie.existsByEmail(dto.getEmail())){
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


    public Clientes ObterClientePorId(int id) {
        return clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao Encontrado"));
    }

    public Clientes AlterarClientePorID(int id, ClientesRequestDTO dto){
        Clientes clienteExistente = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente não existe"));
        clienteExistente.setCpf(dto.getCpf());
        return clienteExistente;
    }
}
