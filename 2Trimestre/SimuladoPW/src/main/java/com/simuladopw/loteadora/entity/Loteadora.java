package com.simuladopw.loteadora.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "loteadora")
@Data
public class Loteadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private String endereco;
    private int telefone;
    private double comissaoTerrenoVendido;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
