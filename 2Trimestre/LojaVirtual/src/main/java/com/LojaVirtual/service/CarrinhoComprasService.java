package com.LojaVirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entity.CarrinhoCompra;
import com.LojaVirtual.repository.CarrinhoCompraRepository;

@Service
public class CarrinhoComprasService {
    
    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra inserir(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataCriacao(new Date());
        CarrinhoCompra carrinhoCompraNova = carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNova;
    }

    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataAtualizacao(new Date());
        return carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
    }

    public void excluir(long id) {
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepository.findById(id).get();
        carrinhoCompraRepository.delete(carrinhoCompra);
    }

}
