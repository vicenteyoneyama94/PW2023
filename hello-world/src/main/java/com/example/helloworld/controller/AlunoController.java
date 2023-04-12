package com.example.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.entidade.Aluno;
import com.example.helloworld.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @PostMapping
    public Aluno salvar(Aluno aLuno) {
        return alunoService.salvar(aLuno);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable ("id") long id) {
        alunoService.excluir(id);
    }

}
