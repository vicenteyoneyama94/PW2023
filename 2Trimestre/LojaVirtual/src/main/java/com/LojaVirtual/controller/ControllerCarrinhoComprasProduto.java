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

import com.LojaVirtual.entity.CarrinhoComprasProduto;
import com.LojaVirtual.service.CarrinhoComprasProdutoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/carrinhocomprasproduto")
@CrossOrigin
public class ControllerCarrinhoComprasProduto {
    
    @Autowired
    private CarrinhoComprasProdutoService carrinhoCompraProdutoService;

    @GetMapping("/")
    public List<CarrinhoComprasProduto> buscarTodos(){
        return carrinhoCompraProdutoService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoComprasProduto inserir(@RequestBody CarrinhoComprasProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoService.inserir(carrinhoCompraProduto);
    }

    @PutMapping("/")
    public CarrinhoComprasProduto alterar(CarrinhoComprasProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoService.alterar(carrinhoCompraProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathParam("id")Long id){
        try{
        carrinhoCompraProdutoService.excluir(id);
        return ResponseEntity.ok().build();
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}