package com.vini.oficina.service;

import com.vini.oficina.dto.request.CarrosRequestDTO;
import com.vini.oficina.model.entitys.Carros;
import com.vini.oficina.model.entitys.Clientes;
import com.vini.oficina.repository.CarrosRepositorie;
import com.vini.oficina.repository.ClienteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CarrosService {
    //todo Finalizar parametro com DTO
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
        carros.setClientes(clientes);

        LocalDateTime agora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

        carros.setData_Cadastro(Timestamp.valueOf(agora));

        carrosRepositorie.save(carros);


        return carros;
    }
}
