package com.LojaVirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    public List<Cidade> findByNomeContainingIgnoreCase(String nome);
}
