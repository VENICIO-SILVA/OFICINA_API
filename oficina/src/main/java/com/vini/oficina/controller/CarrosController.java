package com.vini.oficina.controller;

import com.vini.oficina.dto.request.CarrosRequestDTO;
import com.vini.oficina.model.entitys.Carros;
import com.vini.oficina.service.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Carros")
public class CarrosController {

    @Autowired
    private CarrosService carrosService;

    @PostMapping("/CadastrarCarro/{id}")
    public ResponseEntity<Carros> CadastrarCarro(@PathVariable int id, @RequestBody CarrosRequestDTO dto){
        Carros car = carrosService.CadastrarCarros(id, dto);

        return ResponseEntity.ok(car);
    }


}
