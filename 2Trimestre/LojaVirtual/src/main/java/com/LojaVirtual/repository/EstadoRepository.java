package com.LojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado,Long> {
    
    public List<Estado> findByNomeContainingIgnoreCase(String nome);

}
