package com.LojaVirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entity.Pessoa;
import com.LojaVirtual.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa){
         pessoa.setDataCriacao(new Date());
         Pessoa pessoaNew = pessoaRepository.saveAndFlush(pessoa);
         return pessoaNew;
    }
    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }
    public void excluir(long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}
