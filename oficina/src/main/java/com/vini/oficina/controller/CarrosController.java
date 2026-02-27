package com.vini.oficina.controller;

import com.vini.oficina.dto.request.CarrosRequestDTO;
import com.vini.oficina.dto.response.CarrosResponseDTO;
import com.vini.oficina.model.entities.Carros;
import com.vini.oficina.service.CarrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Carros")
public class CarrosController {


    @Autowired
    private CarrosService carrosService;

    //todo Alterar para devolver response
    @PostMapping("/Cadastrar/{id}")
    public ResponseEntity<Carros> CadastrarCarro(@PathVariable int id, @RequestBody CarrosRequestDTO dto){
        Carros car = carrosService.CadastrarCarros(id, dto);

        return ResponseEntity.ok(car);
    }

    @GetMapping("ObterCarro/")
    public ResponseEntity<List<CarrosResponseDTO>>  ObterCarros(@RequestParam(required = false) Integer id, @RequestParam(required = false) String Marca){
       List<CarrosResponseDTO> Lista  = carrosService.ObterCarros(id, Marca);

        return ResponseEntity.ok(Lista);
    }
    @PutMapping("/Editar/{id}")
    public ResponseEntity<CarrosResponseDTO> AtualizarCarros(@PathVariable int id, @Valid @RequestBody CarrosRequestDTO dto ){
        CarrosResponseDTO carros = carrosService.AtualizarCarro(id, dto);

        return ResponseEntity.ok(carros);
    }

    @DeleteMapping("/ApagarCarro/{id}")
    public ResponseEntity<Void> DeletarCarro(@PathVariable int id){
        carrosService.DeletarCarro(id);

        return ResponseEntity.noContent().build();
    }

}
