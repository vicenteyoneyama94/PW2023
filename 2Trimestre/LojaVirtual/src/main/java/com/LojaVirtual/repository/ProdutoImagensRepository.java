package com.LojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.ProdutoImagens;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long>{
    
    public List<ProdutoImagens> findByProdutoId(Long id);

}
