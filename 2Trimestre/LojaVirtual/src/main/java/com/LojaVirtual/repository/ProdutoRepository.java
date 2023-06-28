package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
