package com.simuladopw.loteadora.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simuladopw.loteadora.entity.Loteadora;
import com.simuladopw.loteadora.repository.LoteadoraRepository;

@Service
public class LoteadoraService {
    
    @Autowired
    private LoteadoraRepository loteadoraRepository;

    public List<Loteadora> buscarTodos(){
        return loteadoraRepository.findAll();
    }

    public Loteadora inserir(Loteadora loteadora){
        loteadora.setDataCriacao(new Date());
        Loteadora loteadora2 = loteadoraRepository.saveAndFlush(loteadora);
        return loteadora2;

    }
    public Loteadora alterar(Loteadora loteadora){
        return loteadoraRepository.saveAndFlush(loteadora);
    }

    public void excluir(Long id){
        Loteadora loteadora = loteadoraRepository.findById(id).get();
        loteadoraRepository.delete(loteadora);
    }
}