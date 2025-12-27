package com.vini.oficina.controller;

import com.vini.oficina.dto.request.AdministradoresRequestDto;
import com.vini.oficina.model.entities.Administradores;
import com.vini.oficina.service.AdministradoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Administradores")
public class AdministradoresController {

    @Autowired
    private AdministradoresService administradoresService;

    @PostMapping("/CadastrarAdministrador")                            //@Valid ativa as validações do DTO
                                                                    //RequestBody diz que recebe JSON inseridor no corpo da requisição ou seja dados via JSON
    public ResponseEntity<Administradores> CadastrarAdministrador(@Valid @RequestBody AdministradoresRequestDto dto) {
        //As informações chegam Atraves da requisição o DTO recebe ela no parametro acima "dto" roda toda verificação @valid

        //Pós verificação e chamado o service.cadastrar passadno "dto" como parametro onde ele vai se tornar dados para o banco atraves da classe de serviço
        Administradores adm = administradoresService.CadastrarAdministrador(dto);

        return ResponseEntity.ok(adm);
    }
    //todo criar get adm para amostra de usuario logado na tela!

}
