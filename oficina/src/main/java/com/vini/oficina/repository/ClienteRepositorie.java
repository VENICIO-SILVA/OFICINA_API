package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepositorie extends JpaRepository<Clientes, Integer> {
    boolean existsByEmail(String email);
    Optional<Clientes> findByEmail(String email);
    List<Clientes> findByNomeContainingIgnoreCase(String nome);
}

