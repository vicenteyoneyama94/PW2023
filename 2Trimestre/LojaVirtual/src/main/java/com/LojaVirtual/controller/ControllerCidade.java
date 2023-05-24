package com.LojaVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.entity.Cidade;

import com.LojaVirtual.service.CidadeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/cidade")
public class ControllerCidade {
    
    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(Cidade cidade){
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathParam("id")Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}