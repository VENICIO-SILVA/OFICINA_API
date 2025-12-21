package com.vini.oficina.repository;

import com.vini.oficina.model.entitys.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorie extends JpaRepository<Clientes, Integer> {
    boolean existsByEmail(String email);
}

