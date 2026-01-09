package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradoresRepositorie extends JpaRepository<Administradores,Integer> {
    boolean existsByEmail(String email);
    Optional<Administradores> findByEmail(String email);
    List<Administradores> findByNomeContainingIgnoreCase(String nome);
}
