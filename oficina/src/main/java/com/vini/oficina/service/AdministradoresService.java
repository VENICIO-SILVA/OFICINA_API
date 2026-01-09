package com.vini.oficina.service;

import com.vini.oficina.dto.request.AdministradoresRequestDto;
import com.vini.oficina.dto.request.LoginRequestDTO;
import com.vini.oficina.dto.response.AdministradoresResponseDTO;
import com.vini.oficina.model.entities.Administradores;
import com.vini.oficina.repository.AdministradoresRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AdministradoresService {
    @Autowired
    private AdministradoresRepositorie administradoresRepositorie;

    //classe de serviço recebeu os dados que chegaram atraves da requisição "NovoAdministrador"
    //Transforma os Dados do "dto" Em "Entitys" apartir da linha 25
    // e persisti no banco da dados
    public Administradores CadastrarAdministrador(AdministradoresRequestDto dto) {
        if (administradoresRepositorie.existsByEmail(dto.getEmail())) {
            //verifica caso exista um email ja cadastrado
            //evita Usuarios duplicados
            System.out.println("Este email ja existe");
        }

        Administradores adm = new Administradores();

        adm.setNome(dto.getNome());
        adm.setEmail(dto.getEmail());
        adm.setSenha(dto.getSenha());
        adm.setTelefone(dto.getTelefone());
        adm.setCargo(dto.getCargo());

        //Seta o dia/hora de criação do Usuario
        Timestamp agora = new Timestamp(System.currentTimeMillis());

        adm.setData_criacao(agora);
        //todo Criar Função separada para Atualização de Dados setdataAtualização


        return administradoresRepositorie.save(adm);
    }

    public Administradores Login(LoginRequestDTO dto) {
        Administradores adm = administradoresRepositorie.findByEmail(dto.getEmail()).orElseThrow(() -> new RuntimeException("Email ou senha invalidos"));
        if (!adm.getSenha().equals(dto.getSenha())) {
            throw new RuntimeException("Email ou senha invalidos");
        }
        return adm;
    }

    public List<Administradores> BuscarAdministradores(String nome, Integer id) {
        if (id != null) {
            return administradoresRepositorie.findById(id)
                    .map(List::of)
                    .orElse(List.of());
        }
        if (nome != null && !nome.isEmpty()) {
            return administradoresRepositorie.findByNomeContainingIgnoreCase(nome);
        }
        return administradoresRepositorie.findAll();
    }

    public void ExcluirUsuario(int id) {
        Administradores adm = administradoresRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        administradoresRepositorie.delete(adm);
    }

    public AdministradoresResponseDTO EditarUsuario(Integer id, AdministradoresRequestDto dto) {
        Administradores adm = administradoresRepositorie.findById(Integer.valueOf(id)).orElseThrow(() -> new RuntimeException("Usuario nao Encontrado"));
        AdministradoresResponseDTO ResponseDTO = new AdministradoresResponseDTO();
        adm.setNome(dto.getNome());
        adm.setEmail(dto.getEmail());
        adm.setSenha(dto.getSenha());
        adm.setTelefone(dto.getTelefone());
        adm.setCargo(dto.getCargo());
        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        adm.setData_atualizacao(Timestamp.valueOf(agora));

        administradoresRepositorie.save(adm);

        ResponseDTO.setNome(adm.getNome());
        ResponseDTO.setEmail(adm.getEmail());
        ResponseDTO.setSenha(adm.getSenha());
        ResponseDTO.setTelefone(adm.getTelefone());
        ResponseDTO.setCargo(adm.getCargo());
        ResponseDTO.setDataAtualizacao(adm.getData_atualizacao());

        return ResponseDTO;


    }
}
