/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author wemerson
 */
@Entity
public class Salao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_salao;
    @Column(length = 11)
    private long cnpj;
    @Column(length = 50, nullable = false)
    private String nome;
    @Embedded
    private Endereco endereco;
    @Column(length = 30)
    private String login;
    @Column(length = 10)
    private String senha;

    public Salao() {
    }

    public Salao(long cnpj, String nome, Endereco endereco, String login, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }

    public int getId_salao() {
        return id_salao;
    }

    public void setId_salao(int id_salao) {
        this.id_salao = id_salao;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_salao;
        hash = 79 * hash + (int) (this.cnpj ^ (this.cnpj >>> 32));
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.login);
        hash = 79 * hash + Objects.hashCode(this.senha);
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
        final Salao other = (Salao) obj;
        if (this.id_salao != other.id_salao) {
            return false;
        }
        if (this.cnpj != other.cnpj) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salao{" + "id_salao=" + id_salao + ", cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
    
}
