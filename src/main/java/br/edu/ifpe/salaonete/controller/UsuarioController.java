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
    
    private UsuarioModel usuarioModel;
    private Usuario cadUsuario;
    
    public UsuarioController(){
        this.usuarioModel = new UsuarioModel();
        this.cadUsuario = new Usuario();
    }
    
    public void cadastrar(){
        this.usuarioModel.cadastrar(this.cadUsuario);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
        this.cadUsuario = new Usuario();
        //return "index.xhtml";
        
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

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public Usuario getCadUsuario() {
        return cadUsuario;
    }

    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }
    
}
