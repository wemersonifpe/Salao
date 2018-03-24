/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Usuario;
import br.edu.ifpe.salaonete.model.negocio.UsuarioModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
    
    private final UsuarioModel usuarioModel;
    private Usuario cadUsuario;
    
    public UsuarioController(){
        this.usuarioModel = new UsuarioModel();
        this.cadUsuario = new Usuario();
    }
    
    public String cadastrar(Usuario usuario){
        this.usuarioModel.cadastrar(usuario);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
        return "index.xhtml";
        
    }
    
    public String alterar(Usuario usuario){
        this.usuarioModel.alterar(usuario);
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario alterado com sucesso"));
        return "index.xhtml";
    }
    
    public String deletar(Usuario usuario){
        this.usuarioModel.deletar(usuario);
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso"));
        return "index.xhtml";
    }
    
    public List<Usuario> recuperarTodos(){
        return this.usuarioModel.recuperarTodos();
    }
    
}
