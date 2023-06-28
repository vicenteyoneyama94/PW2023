package com.LojaVirtual.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.entity.PermissaoPessoa;
import com.LojaVirtual.service.PermissaoPessoaService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/permissaopessoa")
@CrossOrigin
public class ControllerPermissaoPessoa {
    
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @GetMapping("/")
    public List<PermissaoPessoa> buscarTodos(){
        return permissaoPessoaService.buscarTodos();
    }

    @PostMapping("/")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa permissaoPessoa){
        return permissaoPessoaService.inserir(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa alterar(PermissaoPessoa permissaoPessoa){
        return permissaoPessoaService.alterar(permissaoPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathParam("id")Long id){
        try{
        permissaoPessoaService.excluir(id);
        return ResponseEntity.ok().build();
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}