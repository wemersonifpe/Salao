/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Endereco;
import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.negocio.SalaoModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class SalaoController {
    
    private SalaoModel salaoNegocio;
    private Salao salao;
    
    public SalaoController(){
        this.salaoNegocio = new SalaoModel();
        this.salao = new Salao();
    }
    
    public void cadastrar(){
        this.salaoNegocio.cadastrar(this.salao);
        this.salao = new Salao();
    }
    
    public Salao rec(Integer codigo){
        return this.salaoNegocio.recuperar(codigo);
    }
    
    public Salao recupera(Long cnpj){
        return this.salaoNegocio.recuperarCnpj(cnpj);
    }
    
    public String alterar(Salao salao){
        this.salaoNegocio.alterar(salao);
        return "";
    }
    
    public void deletar(Salao salao){
        this.salaoNegocio.deletar(salao);
    }
    
    public List<Salao> listarAction(){
        return this.salaoNegocio.recuperarTodos();
    }
    
    public boolean login(String login,String senha) {
       return this.salaoNegocio.login(login, senha);
    }

    public SalaoModel getSalaoNegocio() {
        return salaoNegocio;
    }

    public void setSalaoNegocio(SalaoModel salaoNegocio) {
        this.salaoNegocio = salaoNegocio;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }
    
}
