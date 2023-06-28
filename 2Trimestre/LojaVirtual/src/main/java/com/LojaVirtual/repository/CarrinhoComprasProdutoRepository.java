package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.CarrinhoComprasProduto;

public interface CarrinhoComprasProdutoRepository extends JpaRepository<CarrinhoComprasProduto, Long> {
    
}
