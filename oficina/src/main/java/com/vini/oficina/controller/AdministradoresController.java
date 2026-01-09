package com.vini.oficina.controller;

import com.vini.oficina.dto.request.AdministradoresRequestDto;
import com.vini.oficina.dto.request.LoginRequestDTO;
import com.vini.oficina.dto.response.AdministradoresResponseDTO;
import com.vini.oficina.model.entities.Administradores;
import com.vini.oficina.service.AdministradoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//todo Refator todos as chamadas  HTTP para response
@RestController
@RequestMapping("/Administradores")
public class AdministradoresController {

    @Autowired
    private AdministradoresService administradoresService;

    @PostMapping("/Cadastrar")                            //@Valid ativa as validações do DTO//RequestBody diz que recebe JSON inseridor no corpo da requisição ou seja dados via JSON
    public ResponseEntity<Administradores> CadastrarAdministrador(@Valid @RequestBody AdministradoresRequestDto dto) {
        //As informações chegam Atraves da requisição o DTO recebe ela no parametro acima "dto" roda toda verificação @valid

        //Pós verificação e chamado o service.cadastrar passadno "dto" como parametro onde ele vai se tornar dados para o banco atraves da classe de serviço
        Administradores adm = administradoresService.CadastrarAdministrador(dto);

        return ResponseEntity.ok(adm);
    }
    @PostMapping("/Login")
    public ResponseEntity<Administradores> Login(@Valid @RequestBody LoginRequestDTO dto){
        Administradores adm = administradoresService.Login(dto);

        return ResponseEntity.ok(adm);
    }
    @GetMapping("/BuscarUsuario/")
    public ResponseEntity<List<Administradores>> BuscarAdministrador(@RequestParam(required = false) String nome, @RequestParam(required = false) Integer id) {

        List<Administradores> lista = administradoresService.BuscarAdministradores(nome, id);
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/ExcluirUsuario/{id}")
    public ResponseEntity<Void> ExcluirUsuario(@PathVariable int id){
        administradoresService.ExcluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("EditarUsuario/{id}")
    public ResponseEntity<AdministradoresResponseDTO> EditarUsuario(@Valid @PathVariable Integer id, @RequestBody AdministradoresRequestDto dto){
        AdministradoresResponseDTO adm = administradoresService.EditarUsuario(id, dto);

        return ResponseEntity.ok(adm);

        }
    }

