package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
