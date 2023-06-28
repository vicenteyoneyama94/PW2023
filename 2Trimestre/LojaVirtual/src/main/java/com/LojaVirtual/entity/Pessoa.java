package com.LojaVirtual.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permissao permissao;

    @ManyToOne
    @JoinColumn(name = "idPermissaopessoa")
    private PermissaoPessoa permissaoPessoa;

    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "idCarrinho_compra")
    private CarrinhoCompra carrinhoCompra;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    

}
