/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

/**
 *
 * @author wemerson
 */
public class Endereco {
    
    private int numero;
    private String rua;
    private String bairro;
    private String cidaded;

    public Endereco() {
    }

    public Endereco(int numero, String rua, String bairro, String cidaded) {
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidaded = cidaded;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidaded() {
        return cidaded;
    }

    public void setCidaded(String cidaded) {
        this.cidaded = cidaded;
    }
    
}
