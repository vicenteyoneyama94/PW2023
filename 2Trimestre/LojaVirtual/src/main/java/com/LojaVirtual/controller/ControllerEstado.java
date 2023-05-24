package com.LojaVirtual.controller;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.entity.Estado;
import com.LojaVirtual.service.EstadoService;


@RestController
@RequestMapping("/api/estado")
@CrossOrigin
public class ControllerEstado {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/{id}")
    public List<Estado> buscarTodos(){
        return estadoService.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(Estado estado){
        return estadoService.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(Estado estado){
        return estadoService.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathParam("id")Long id){
        try{
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
