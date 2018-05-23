/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wemerson
 */
@Entity
public class Servicos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_servico;
    @ManyToOne
    @JoinColumn(name = "cod_salao", referencedColumnName = "id_salao", nullable = false)
    private Salao salao;
    @Column(length = 30)
    private String nome;
    @Column(length = 100)
    private String descricao;
    @Column
    private double valor;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date duracao;

    public Servicos() {
    }

    public Servicos(Salao salao, String nome, String descricao, double valor, Date duracao) {
        this.salao = salao;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_servico;
        hash = 29 * hash + Objects.hashCode(this.salao);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.duracao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servicos other = (Servicos) obj;
        if (this.id_servico != other.id_servico) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.salao, other.salao)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicos{" + "id_servico=" + id_servico + ", salao=" + salao + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", duracao=" + duracao + '}';
    }

    
}
