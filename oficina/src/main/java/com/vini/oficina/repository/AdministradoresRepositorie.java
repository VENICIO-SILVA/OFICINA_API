package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradoresRepositorie extends JpaRepository<Administradores,Integer> {
    boolean existsByEmail(String email);
}
