package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrosRepositorie extends JpaRepository<Carros,Integer> {
    Optional<Carros> findById(int id);

    List<Carros> findByMarcaContainingIgnoreCase(String Marca);
}
