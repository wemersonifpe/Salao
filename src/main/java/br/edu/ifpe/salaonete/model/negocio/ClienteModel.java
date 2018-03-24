/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.negocio;

import br.edu.ifpe.salaonete.model.DAo.DAO;
import br.edu.ifpe.salaonete.model.entidade.ClienteSalao;
import br.edu.ifpe.salaonete.model.hibernate.ClienteSalaoHibernateDao;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class ClienteModel {
    
    private final DAO<ClienteSalao> dao;
    
    public ClienteModel(){
        this.dao = ClienteSalaoHibernateDao.getInstance();
    }
    
    public void cadastrar(ClienteSalao cliente){
        if(((ClienteSalaoHibernateDao)dao).recuperar(cliente.getId()) == null){
            this.dao.inserir(cliente);
        }
    }
    
    public ClienteSalao recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((ClienteSalaoHibernateDao)dao).recuperar(codigo);
    }
    
    public void alterar(ClienteSalao cliente){
        if(((ClienteSalaoHibernateDao)dao).recuperar(cliente.getId()) != null){
            this.dao.alterar(cliente);
        }
    }
    
    public void deletar(ClienteSalao cliente){
        if(((ClienteSalaoHibernateDao)dao).recuperar(cliente.getId()) != null){
            this.dao.deletar(cliente);
        }
    }
    
    public List<ClienteSalao> recuperarTodos(){
        return ((ClienteSalaoHibernateDao)dao).recuperarTodos();
    }
}
