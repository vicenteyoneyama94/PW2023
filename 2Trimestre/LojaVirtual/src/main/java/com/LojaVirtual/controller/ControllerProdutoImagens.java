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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.LojaVirtual.entity.ProdutoImagens;
import com.LojaVirtual.service.ProdutoImagensService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/produtoimagens")
@CrossOrigin
public class ControllerProdutoImagens {
    
    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/produto/{id}")
    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensService.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return produtoImagensService.inserir(idProduto, file);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(ProdutoImagens produtoImagens){
        return produtoImagensService.alterar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathParam("id")Long id){
        try{
        produtoImagensService.excluir(id);
        return ResponseEntity.ok().build();
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}