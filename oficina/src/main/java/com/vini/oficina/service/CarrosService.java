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

    public CarrosResponseDTO ObterCarroPorID(int id) {
        Carros carros = carrosRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Carro nao encontrado"));
        Clientes clientes = carros.getCliente();

        CarrosResponseDTO responseDTO = new CarrosResponseDTO();

        responseDTO.setId(carros.getId());
        responseDTO.setModelo(carros.getModelo());
        responseDTO.setCor(carros.getCor());
        responseDTO.setAno(carros.getAno());
        responseDTO.setPlaca(carros.getPlaca());
        responseDTO.setIdCliente(carros.getCliente().getId());
        responseDTO.setNomeCliente(clientes.getNome());
        responseDTO.setDataCadastro(carros.getData_Cadastro());
        responseDTO.setDataAtualizacao(carros.getData_Atualizacao());

        return responseDTO;
    }

    public Carros AtualizarCarro(int id, CarrosRequestDTO dto) {
        Carros carros = carrosRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Carro nao encontrado"));
        carros.setModelo(dto.getModelo());
        carros.setMarca(dto.getMarca());
        carros.setAno(dto.getAno());
        carros.setCor(dto.getCor());
        carros.setPlaca(dto.getPlaca());


        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

        carros.setData_Atualizacao(Timestamp.valueOf(agora));

        carrosRepositorie.save(carros);

        return carros;
    }

    public void DeletarCarro(int id, CarrosRequestDTO dto) {
        Carros carros = carrosRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Carro nao encontrado"));
        carrosRepositorie.delete(carros);
    }
}
