package com.simuladopw.loteadora.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "terreno")
@Data
public class Terreno {
    
    private long id;
    private String endereco;
    private double medidas;
    private double valorPedida;
    private double valorVenda;

    private Date dataCriacao;
    private Date dataAtualizacao;

}
