package com.LojaVirtual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entity.PermissaoPessoa;
import com.LojaVirtual.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {
    
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    public List<PermissaoPessoa> buscarTodos() {
        return permissaoPessoaRepository.findAll();
    }

    public PermissaoPessoa inserir(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setDataCriacao(new Date());
        PermissaoPessoa permissaoPessoaNova = permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        return permissaoPessoaNova;
    }

    public PermissaoPessoa alterar(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setDataAtualizacao(new Date());
        return permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
    }

    public void excluir(long id) {
        PermissaoPessoa permissaoPessoa = permissaoPessoaRepository.findById(id).get();
        permissaoPessoaRepository.delete(permissaoPessoa);
    }

}
