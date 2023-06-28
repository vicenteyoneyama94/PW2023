package com.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
}
