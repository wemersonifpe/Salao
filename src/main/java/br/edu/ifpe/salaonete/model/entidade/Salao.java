/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author wemerson
 */
@Entity
public class Salao implements Serializable {
    
    @Id
    @GeneratedValue
    private int id_salao;
    @Column(length = 11)
    private long cnpj;
    @Column(length = 50, nullable = false)
    private String nome;
    //private Endereco endereco;
    @Column(length = 30)
    private String login;
    @Column(length = 10)
    private String senha;

    public Salao() {
    }
    
    public Salao(String nome, long cnpj, String login, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.login = login;
        this.senha = senha;
    }

    public int getId_salao() {
        return id_salao;
    }

    public void setId_salao(int id_salao) {
        this.id_salao = id_salao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
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
    
}
