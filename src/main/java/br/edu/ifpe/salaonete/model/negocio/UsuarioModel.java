/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.negocio;

import br.edu.ifpe.salaonete.model.DAo.DAO;
import br.edu.ifpe.salaonete.model.entidade.Usuario;
import br.edu.ifpe.salaonete.model.hibernate.UsuarioHibernateDao;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class UsuarioModel {
    
    private final DAO<Usuario> dao;
    
    public UsuarioModel(){
        this.dao = UsuarioHibernateDao.getInstance();
    }
    
    public void cadastrar(Usuario usuario){
        if(((UsuarioHibernateDao)dao).recuperar(usuario.getId_usuario())==null){
            this.dao.inserir(usuario);
        }
    }
    
    public Usuario recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((UsuarioHibernateDao)dao).recuperar(codigo);
    }
    
    public void alterar(Usuario usuario){
        if(((UsuarioHibernateDao)dao).recuperar(usuario.getId_usuario())!=null){
            this.dao.alterar(usuario);
        }
    }
    
    public void deletar(Usuario usuario){
        if(((UsuarioHibernateDao)dao).recuperar(usuario.getId_usuario())!=null){
            this.dao.deletar(usuario);
        }
    }
    
    public List<Usuario> recuperarTodos(){
        return ((UsuarioHibernateDao)dao).recuperarTodos();
    }
}
