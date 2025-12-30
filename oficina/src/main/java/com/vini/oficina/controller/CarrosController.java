package com.vini.oficina.controller;

import com.vini.oficina.dto.request.CarrosRequestDTO;
import com.vini.oficina.dto.response.CarrosResponseDTO;
import com.vini.oficina.model.entities.Carros;
import com.vini.oficina.service.CarrosService;
import jakarta.validation.Valid;
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

    @GetMapping("ObterCarro/{id}")
    public ResponseEntity<CarrosResponseDTO> ObterCarrosPorID(@PathVariable int id){
        CarrosResponseDTO responseDTO = carrosService.ObterCarroPorID(id);

        return ResponseEntity.ok(responseDTO);
    }
    //todo Atualizar ResponseDTO
    @PutMapping("/AtualizarCarro/{id}")
    public ResponseEntity<Carros> AtualizarCarros(@PathVariable int id, @Valid @RequestBody CarrosRequestDTO dto ){
        Carros carros = carrosService.AtualizarCarro(id, dto);

        return ResponseEntity.ok(carros);
    }

    @DeleteMapping("/ApagarCarro/{id}")
    public ResponseEntity<Void> DeletarCarro(@PathVariable int id){
        carrosService.DeletarCarro(id);

        return ResponseEntity.noContent().build();
    }

}
