package com.LojaVirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LojaVirtual.entity.CarrinhoComprasProduto;
import com.LojaVirtual.repository.CarrinhoComprasProdutoRepository;

@Service
public class CarrinhoComprasProdutoService {
    
    @Autowired
    private CarrinhoComprasProdutoRepository carrinhoComprasProdutoRepository;

    public List<CarrinhoComprasProduto> buscarTodos() {
        return carrinhoComprasProdutoRepository.findAll();
    }

    public CarrinhoComprasProduto inserir(CarrinhoComprasProduto carrinhoComprasProduto) {
        carrinhoComprasProduto.setDataCriacao(new Date());
        CarrinhoComprasProduto carrinhoComprasProdutoNova = carrinhoComprasProdutoRepository.saveAndFlush(carrinhoComprasProduto);
        return carrinhoComprasProdutoNova;
    }

    public CarrinhoComprasProduto alterar(CarrinhoComprasProduto carrinhoComprasProduto) {
        carrinhoComprasProduto.setDataAtualizacao(new Date());
        return carrinhoComprasProdutoRepository.saveAndFlush(carrinhoComprasProduto);
    }

    public void excluir(long id) {
        CarrinhoComprasProduto carrinhoComprasProduto = carrinhoComprasProdutoRepository.findById(id).get();
        carrinhoComprasProdutoRepository.delete(carrinhoComprasProduto);
    }
}
