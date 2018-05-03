/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.edu.ifpe.salaonete.model.DAo.SalaoDAO;

/**
 *
 * @author wemerson
 */
public class SalaoHibernateDao implements SalaoDAO{
    
    private static SalaoHibernateDao instance;
    
    public static SalaoHibernateDao getInstance(){
        if(instance == null){
            instance = new SalaoHibernateDao();
        }
        return instance;
    }

    @Override
    public void recuperarCNPJ(long cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Salao salao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.save(salao);
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
    public void alterar(Salao salao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.update(salao);
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
    public Salao recuperar(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Salao salao = null;
        
        try{
            Query consulta = session.createQuery("SELECT salao FROM Salao salao WHERE salao.id_salao = :id_salao");
            consulta.setInteger("id_salao", codigo);
            salao = (Salao) consulta.uniqueResult();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return salao;
    }

    @Override
    public void deletar(Salao salao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = session.beginTransaction();
            session.delete(salao);
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
    public List<Salao> recuperarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Salao> saloes = null;
        
        try{
            Query consulta = session.createQuery("SELECT saloes FROM Salao saloes");
            saloes = consulta.list();
        }catch(RuntimeException e){
            throw e;
        }finally{
            session.close();
        }
        return saloes;
    }

    @Override
    public boolean login(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
