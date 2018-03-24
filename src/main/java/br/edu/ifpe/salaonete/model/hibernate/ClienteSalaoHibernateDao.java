/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.DAo.ClienteSalaoDAO;
import br.edu.ifpe.salaonete.model.entidade.ClienteSalao;
import br.edu.ifpe.salaonete.model.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wemerson
 */
public class ClienteSalaoHibernateDao implements ClienteSalaoDAO{
    
    private static ClienteSalaoHibernateDao instance;
    
    public static ClienteSalaoHibernateDao getInstance(){
        if(instance == null){
            instance = new ClienteSalaoHibernateDao();
        }
        return instance;
    }

    @Override
    public void recuperarCNPJ(long cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(ClienteSalao cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.save(cliente);
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
    public void alterar(ClienteSalao cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.update(cliente);
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
    public ClienteSalao recuperar(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClienteSalao cliente = null;
        
        try{
            Query consulta = session.createQuery("SELECT cliente FROM ClienteSalao cliente WHERE cliente.id = :id");
            consulta.setInteger("id", codigo);
            cliente = (ClienteSalao) consulta.uniqueResult();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return cliente;
    }

    @Override
    public void deletar(ClienteSalao cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.delete(cliente);
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
    public List<ClienteSalao> recuperarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ClienteSalao> clientes = null;
        
        try{
            Query consulta = session.createQuery("SELECT clientes FROM ClienteSalao clientes");
            clientes = consulta.list();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return clientes;
    }
    
}
