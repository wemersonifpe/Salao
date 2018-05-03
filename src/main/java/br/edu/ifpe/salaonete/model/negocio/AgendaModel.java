/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.negocio;

import br.edu.ifpe.salaonete.model.DAo.DAO;
import br.edu.ifpe.salaonete.model.entidade.Agenda;
import br.edu.ifpe.salaonete.model.hibernate.AgendaHibernateDao;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class AgendaModel {
    
    private final DAO<Agenda> dao;
    
    public AgendaModel(){
        this.dao = AgendaHibernateDao.getInstance();
    }
    
    public void cadastrar(Agenda agenda){
        if(((AgendaHibernateDao)dao).recuperar(agenda.getId_agenda())==null){
            this.dao.inserir(agenda);
        }
    }
    
    public Agenda recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((AgendaHibernateDao)dao).recuperar(codigo);
    }
    
    public void alterar(Agenda agenda){
        if(((AgendaHibernateDao)dao).recuperar(agenda.getId_agenda())!=null){
            this.dao.alterar(agenda);
        }
    }
    
    public void deletar(Agenda agenda){
        if(((AgendaHibernateDao)dao).recuperar(agenda.getId_agenda())!=null){
            this.dao.deletar(agenda);
        }
    }
    
    public List<Agenda> recuperarTodos(){
        return ((AgendaHibernateDao)dao).recuperarTodos();
    }
    
}
