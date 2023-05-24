package com.LojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entity.Estado;
import com.LojaVirtual.repository.EstadoRepository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    
    
    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }
    
    public Estado inserir (Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar (Estado estado){
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir (Long id){
        Estado estado = estadoRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Estado não encontrado"));

        estadoRepository.delete(estado);
    }
}
