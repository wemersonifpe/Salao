/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wemerson
 */
@Entity
public class Servicos implements Serializable {
    
    @Id
    @GeneratedValue
    private int id_servico;
    @ManyToOne
    @JoinColumn(name = "cod_salao", referencedColumnName = "id_salao", nullable = false)
    private Salao salao;
    @Column(length = 30)
    private String nome;
    @Column(length = 100)
    private String descriocao;
    @Column
    private double valor;
    private Time duracao;

    public Servicos() {
        this.salao = new Salao();
    }

    public Servicos(String nome, double valor, String descriocao, Time duracao) {
        this.nome = nome;
        this.valor = valor;
        this.descriocao = descriocao;
        this.duracao = duracao;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
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
