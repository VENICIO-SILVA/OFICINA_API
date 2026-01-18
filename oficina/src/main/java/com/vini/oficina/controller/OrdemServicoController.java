package com.vini.oficina.controller;


import com.vini.oficina.dto.request.OrdemServicoRequestDTO;
import com.vini.oficina.dto.response.OrdemServicoResponseDTO;
import com.vini.oficina.model.entities.OrdemServico;
import com.vini.oficina.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Os")
public class OrdemServicoController {
    @Autowired
    private OrdemServicoService ordemServicoService;

    //todo Alterar para devolver response
    @PostMapping("/GerarOrdem/{id}")
    public ResponseEntity<OrdemServico> GerarOrdem(@PathVariable int id, @Valid @RequestBody OrdemServicoRequestDTO dto){
        OrdemServico ordemServico = ordemServicoService.GerarOrdem(id, dto);

        return ResponseEntity.ok(ordemServico);

    }
    @GetMapping("/ObterOrdemServico/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> ObterOrdemServico(@PathVariable int id){
        OrdemServicoResponseDTO ResponseDTO = ordemServicoService.ObterOrdemServico(id);

        return ResponseEntity.ok(ResponseDTO);
    }

}
