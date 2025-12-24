package com.vini.oficina.service;

import com.vini.oficina.model.entitys.Carros;
import com.vini.oficina.repository.CarrosRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrosService {
    //todo Finalizar parametro com DTO
    @Autowired
    private CarrosRepositorie carrosRepositorie;

    public Carros CadastrarCarros(int id, Carros dto){
        Carros car = new Carros();

        ca
        return null;
    }
}
