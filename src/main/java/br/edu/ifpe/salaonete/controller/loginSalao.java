/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Salao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class loginSalao {
    
    private Salao salaoLogado = null;
    
    public loginSalao(){
        
    }
    
    public String realizarLogin(String login, String senha){
        List<Salao> saloes = new SalaoController().listarAction();
        
        for(Salao s : saloes){
            if(s.getLogin().equals(login)){
                if(s.getSenha().equals(senha)){
                    this.salaoLogado = s;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salaoLogado", s);
                    return "menusalao.xhtml";
                }
            }
        }
        return "";
    }

    public Salao getSalaoLogado() {
        return salaoLogado;
    }

    public void setSalaoLogado(Salao salaoLogado) {
        this.salaoLogado = salaoLogado;
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
    
}
