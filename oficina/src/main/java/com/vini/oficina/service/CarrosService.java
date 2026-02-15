package com.vini.oficina.service;

import com.vini.oficina.dto.request.CarrosRequestDTO;
import com.vini.oficina.dto.response.CarrosResponseDTO;
import com.vini.oficina.model.entities.Carros;
import com.vini.oficina.model.entities.Clientes;
import com.vini.oficina.repository.CarrosRepositorie;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepositorie carrosRepositorie;
    @Autowired
    private ClienteRepositorie clienteRepositorie;

    public Carros CadastrarCarros(int id, CarrosRequestDTO dto) {
        Clientes clientes = clienteRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Nao encontrado"));
        Carros carros = new Carros();

        carros.setModelo(dto.getModelo());
        carros.setMarca(dto.getMarca());
        carros.setAno(dto.getAno());
        carros.setCor(dto.getCor());
        carros.setPlaca(dto.getPlaca());
        carros.setCliente(clientes);

        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

        carros.setData_Cadastro(Timestamp.valueOf(agora));

        carrosRepositorie.save(carros);


        return carros;
    }
    public List<CarrosResponseDTO> ObterCarros(Integer id, String marca) {
        if (id != null) {
            return carrosRepositorie.findById(id)
                    .map(carro -> List.of(new CarrosResponseDTO(carro)))
                    .orElse(List.of());
        }

        if (marca != null && !marca.isEmpty()) {
            return carrosRepositorie.findByMarcaContainingIgnoreCase(marca)
                    .stream()
                    .map(CarrosResponseDTO::new) // usa o construtor que recebe Carros
                    .toList();
        }

        return carrosRepositorie.findAll()
                .stream()
                .map(CarrosResponseDTO::new) // converte todos para DTO
                .toList();
    }

    public CarrosResponseDTO AtualizarCarro(int id, CarrosRequestDTO dto) {
        Carros carros = carrosRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Carro nao encontrado"));
        CarrosResponseDTO responseDTO = new CarrosResponseDTO();
        carros.setModelo(dto.getModelo());
        carros.setMarca(dto.getMarca());
        carros.setAno(dto.getAno());
        carros.setCor(dto.getCor());
        carros.setPlaca(dto.getPlaca());
        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        carros.setData_Atualizacao(Timestamp.valueOf(agora));

        responseDTO.setModelo(carros.getModelo());
        responseDTO.setMarca(carros.getMarca());
        responseDTO.setAno(carros.getAno());
        responseDTO.setCor(carros.getCor());
        responseDTO.setPlaca(carros.getPlaca());


        carrosRepositorie.save(carros);

        return responseDTO;
    }

    public void DeletarCarro(int id) {
        Carros carros = carrosRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Carro nao encontrado"));
        carrosRepositorie.delete(carros);
    }
}
