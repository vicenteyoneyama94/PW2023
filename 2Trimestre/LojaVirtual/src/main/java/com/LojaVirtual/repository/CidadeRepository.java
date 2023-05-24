package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
