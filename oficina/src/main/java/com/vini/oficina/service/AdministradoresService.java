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

    public Administradores CadastrarAdministrador(AdministradoresRequestDto dto) {
        if (administradoresRepositorie.existsByEmail(dto.getEmail())) {
            System.out.println("Este email ja existe");
        }

        Administradores adm = new Administradores();

        adm.setNome(dto.getNome());
        adm.setEmail(dto.getEmail());
        adm.setSenha(dto.getSenha());
        adm.setTelefone(dto.getTelefone());
        adm.setCargo(dto.getCargo());

        Timestamp agora = new Timestamp(System.currentTimeMillis());

        adm.setData_criacao(agora);
        adm.setData_atualizacao(agora);


        return administradoresRepositorie.save(adm);
    }
}
