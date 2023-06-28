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

import com.LojaVirtual.entity.CarrinhoCompra;
import com.LojaVirtual.service.CarrinhoComprasService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/carrinhocompra")
@CrossOrigin
public class ControllerCarrinhoCompra {
    
    @Autowired
    private CarrinhoComprasService carrinhoCompraService;

    @GetMapping("/")
    public List<CarrinhoCompra> buscarTodos(){
        return carrinhoCompraService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.inserir(carrinhoCompra);
    }

    @PutMapping("/")
    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.alterar(carrinhoCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathParam("id")Long id){
        try{
        carrinhoCompraService.excluir(id);
        return ResponseEntity.ok().build();
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
