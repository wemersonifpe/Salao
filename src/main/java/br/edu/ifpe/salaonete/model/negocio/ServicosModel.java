/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.negocio;

import br.edu.ifpe.salaonete.model.DAo.DAO;
import br.edu.ifpe.salaonete.model.entidade.Servicos;
import br.edu.ifpe.salaonete.model.hibernate.ServicosHibernateDao;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class ServicosModel {
    
   private final DAO<Servicos> dao;
    
    public ServicosModel(){
        this.dao = ServicosHibernateDao.getInstance();
    }
    
    public void cadastrar(Servicos servicos){
        if(((ServicosHibernateDao)dao).recuperar(servicos.getId_servico())==null){
            this.dao.inserir(servicos);
        }
    }
    
    public Servicos recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((ServicosHibernateDao)dao).recuperar(codigo);
    }
    
    public void alterar(Servicos servicos){
        if(((ServicosHibernateDao)dao).recuperar(servicos.getId_servico())!=null){
            this.dao.alterar(servicos);
        }
    }
    
    public void deletar(Servicos servicos){
        if(((ServicosHibernateDao)dao).recuperar(servicos.getId_servico())!=null){
            this.dao.deletar(servicos);
        }
    }
    
    public List<Servicos> recuperarTodos(){
        return ((ServicosHibernateDao)dao).recuperarTodos();
    } 
}
