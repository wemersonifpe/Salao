/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.DAo.UsuarioDAO;
import br.edu.ifpe.salaonete.model.entidade.Usuario;
import br.edu.ifpe.salaonete.model.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wemerson
 */
public class UsuarioHibernateDao implements UsuarioDAO{
    
    private static UsuarioHibernateDao instance;
    
    public static UsuarioHibernateDao getInstance(){
        if(instance == null){
            instance = new UsuarioHibernateDao();
        }
        return instance;
    }

    @Override
    public void recuperarCPF(long cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(transacao != null){
                transacao.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(transacao != null){
                transacao.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public Usuario recuperar(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        
        try{
            Query consulta = session.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.id_usuario = :id_usuario");
            consulta.setInteger("id_usuario", codigo);
            usuario = (Usuario) consulta.uniqueResult();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return usuario;
    }

    @Override
    public void deletar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(transacao != null){
                transacao.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public List<Usuario> recuperarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> usuarios = null;
        
        try{
            Query consulta = session.createQuery("SELECT usuarios FROM Usuario usuarios");
            usuarios = consulta.list();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return usuarios;
    }

    @Override
    public boolean login(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
