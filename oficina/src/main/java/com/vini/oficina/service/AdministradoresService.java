package com.vini.oficina.service;

import com.vini.oficina.dto.request.AdministradoresRequestDto;
import com.vini.oficina.model.entitys.Administradores;
import com.vini.oficina.repository.AdministradoresRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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
}
