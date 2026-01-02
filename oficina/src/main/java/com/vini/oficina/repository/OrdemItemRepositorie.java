package com.vini.oficina.repository;

import com.vini.oficina.model.entities.OrdemServicoItens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepositorie extends JpaRepository<OrdemServicoItens, Integer> {
}
