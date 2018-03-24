/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author wemerson
 */
@Entity
public class Servicos {
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private double valor;
    private String descriocao;
    private Time duracao;

    public Servicos(String nome, double valor, String descriocao, Time duracao) {
        this.nome = nome;
        this.valor = valor;
        this.descriocao = descriocao;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescriocao() {
        return descriocao;
    }

    public void setDescriocao(String descriocao) {
        this.descriocao = descriocao;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }
    
    
}
