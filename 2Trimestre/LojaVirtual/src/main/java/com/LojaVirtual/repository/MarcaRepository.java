package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
