package com.example.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloworld.entidade.Aluno;
import com.example.helloworld.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aLuno){
        return alunoRepository.save(aLuno);
    }

    public Aluno atualizar (Aluno aLuno){
        return alunoRepository.saveAndFlush(aLuno);
    }

    public void excluir (Long id){
        Aluno aluno = alunoRepository.findById(id).get();
        alunoRepository.delete(aluno);
    }

}
