package com.vini.oficina.service;

import com.vini.oficina.dto.request.ClientesRequestDTO;
import com.vini.oficina.dto.response.ClienteResponseDTO;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.repository.CarrosRepositorie;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

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


    public List<Clientes> ObterClientePorId(String nome, Integer id) {
        if (id != null) {
            return clienteRepositorie.findById(id)
                    .map(List::of)
                    .orElse(List.of());
        }
        if (nome != null && !nome.isEmpty()) {
            return clienteRepositorie.findByNomeContainingIgnoreCase(nome);
        }
        return clienteRepositorie.findAll();

    }

    public ClienteResponseDTO AlterarClientePorID(int id, ClientesRequestDTO dto) {
        Clientes cliente = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente não existe"));
        ClienteResponseDTO RespondeDTO = new ClienteResponseDTO();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        cliente.setData_atualizacao(Timestamp.valueOf(agora));

        clienteRepositorie.save(cliente);

        RespondeDTO.setNome(cliente.getNome());
        RespondeDTO.setNome(cliente.getEmail());
        RespondeDTO.setNome(cliente.getCpf());
        RespondeDTO.setNome(cliente.getTelefone());
        RespondeDTO.setNome(cliente.getEndereco());
        RespondeDTO.setNome(cliente.getData_atualizacao().toString());
        return RespondeDTO;
    }

    public void ApagarClientePorID(int id) {
        Clientes DeletCliente = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Cliente Nao existe"));
        clienteRepositorie.delete(DeletCliente);
    }
}
