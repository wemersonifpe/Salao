/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.DAo.ServicosDAO;
import br.edu.ifpe.salaonete.model.entidade.Servicos;
import br.edu.ifpe.salaonete.model.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wemerson
 */
public class ServicosHibernateDao implements ServicosDAO{
    
    private static ServicosHibernateDao instance;
    
    public static ServicosHibernateDao getInstance(){
        if(instance == null){
            instance = new ServicosHibernateDao();
        }
        return instance;
    }

    @Override
    public void inserir(Servicos servico) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.save(servico);
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
    public void alterar(Servicos servico) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao= session.beginTransaction();
            session.update(servico);
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
    public Servicos recuperar(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Servicos servico = null;
        
        try{
            Query consulta = session.createQuery("SELECT servico FROM Servicos servico WHERE servico.id = :id");
            consulta.setInteger("id", codigo);
            servico = (Servicos) consulta.uniqueResult();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return servico;
    }

    @Override
    public void deletar(Servicos servico) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.delete(servico);
            session.beginTransaction().commit();
        }catch(RuntimeException e){
            if(transacao != null){
                transacao.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public List<Servicos> recuperarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Servicos> servicos = null;
        
        try{
            Query consulta = session.createQuery("SELECT servicos FROM Servicos servicos");
            servicos = consulta.list();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return servicos;
    }
    
}
