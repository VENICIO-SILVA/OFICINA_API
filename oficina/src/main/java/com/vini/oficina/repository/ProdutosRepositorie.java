package com.vini.oficina.repository;

import com.vini.oficina.model.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepositorie extends JpaRepository<Produtos,Integer> {
}
