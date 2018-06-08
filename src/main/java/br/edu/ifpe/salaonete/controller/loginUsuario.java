/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Usuario;
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
public class loginUsuario {
    
    private Usuario usuarioLogado = null;
    
    public loginUsuario(){
        
    }
    
    public String realizarLogin(String login, String senha){
        List<Usuario> usuarios = new UsuarioController().listarAction();
        
        for(Usuario u : usuarios){
            if(u.getLogin().equals(login)){
                if(u.getSenha().equals(senha)){
                    this.usuarioLogado = u;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", u);
                    return "menuusuario.xhtml";
                }
            }
        }
        return "";
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
    
}
