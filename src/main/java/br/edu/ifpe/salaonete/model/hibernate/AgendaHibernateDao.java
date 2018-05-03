/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.DAo.AgendaDAO;
import br.edu.ifpe.salaonete.model.entidade.Agenda;
import br.edu.ifpe.salaonete.model.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wemerson
 */
public class AgendaHibernateDao implements AgendaDAO{
    
    private static AgendaHibernateDao instance;
    
    public static AgendaHibernateDao getInstance(){
        if(instance == null){
            instance = new AgendaHibernateDao();
        }
        return instance;
    }

    @Override
    public void inserir(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.save(agenda);
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
    public void alterar(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao= session.beginTransaction();
            session.update(agenda);
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
    public Agenda recuperar(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Agenda agenda = null;
        
        try{
            Query consulta = session.createQuery("SELECT ageenda FROM Agenda agenda WHERE agenda.id_agenda = :id_agenda");
            consulta.setInteger("id_agenda", codigo);
            agenda = (Agenda) consulta.uniqueResult();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return agenda;
    }

    @Override
    public void deletar(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.delete(agenda);
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
    public List<Agenda> recuperarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Agenda> agendas = null;
        
        try{
            Query consulta = session.createQuery("SELECT agendas FROM Agenda agendas");
            agendas = consulta.list();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return agendas;
    }

   
}
