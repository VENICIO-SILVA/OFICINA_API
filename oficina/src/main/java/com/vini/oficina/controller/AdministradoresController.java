package com.vini.oficina.controller;

import com.vini.oficina.dto.request.AdministradoresRequestDto;
import com.vini.oficina.model.entitys.Administradores;
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

    @PostMapping("/NovoAdministrador")
    public ResponseEntity<Administradores> CadastrarAdministrador(@Valid @RequestBody AdministradoresRequestDto dto) {
        Administradores adm = administradoresService.CadastrarAdministrador(dto);

        return ResponseEntity.ok(adm);
    }

}
