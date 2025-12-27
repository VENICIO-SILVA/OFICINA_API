package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepositorie extends JpaRepository<Carros,Integer> {

}
