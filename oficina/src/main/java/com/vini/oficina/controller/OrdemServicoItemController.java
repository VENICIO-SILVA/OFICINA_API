package com.vini.oficina.controller;


import com.vini.oficina.dto.request.OrdemItemRequestDTO;
import com.vini.oficina.dto.response.OrdemItemResponseDTO;
import com.vini.oficina.service.OrdemItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OsItem")
public class OrdemServicoItemController {
    @Autowired
    private OrdemItemService ordemItemService;

    @PostMapping("/CadastrarOrdemItem/{idOs}")
    public ResponseEntity<OrdemItemResponseDTO> CadastrarOrdemItem(@PathVariable int idOs, @Valid @RequestBody OrdemItemRequestDTO dto){
        OrdemItemResponseDTO response = ordemItemService.CadastrarOrdemItem(idOs, dto);
        return ResponseEntity.ok(response);
    }

}
