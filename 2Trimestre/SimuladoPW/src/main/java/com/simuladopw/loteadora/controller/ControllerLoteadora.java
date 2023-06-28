package com.simuladopw.loteadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simuladopw.loteadora.entity.Loteadora;
import com.simuladopw.loteadora.service.LoteadoraService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/loteadora")
@CrossOrigin
public class ControllerLoteadora {
    
    @Autowired
    private LoteadoraService loteadoraService;

    @GetMapping("/")
    public List<Loteadora> buscarTodos(){
        return loteadoraService.buscarTodos();
    }
    
    @PostMapping("/")
    public Loteadora inserir(@RequestBody Loteadora loteadora){
        return loteadoraService.inserir(loteadora);
    }

    @PutMapping("/")
    public Loteadora alterar(Loteadora loteadora){
        return loteadoraService.alterar(loteadora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathParam("id")Long id){
        loteadoraService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
