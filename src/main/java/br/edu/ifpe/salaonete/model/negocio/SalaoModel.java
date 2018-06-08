/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.negocio;

import br.edu.ifpe.salaonete.model.DAo.DAO;
import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.hibernate.SalaoHibernateDao;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class SalaoModel {
    
    private final DAO<Salao> dao;
    
    public SalaoModel(){
        this.dao = SalaoHibernateDao.getInstance();
    }
    
    public void cadastrar(Salao salao){
        if(((SalaoHibernateDao)dao).recuperar(salao.getId_salao()) == null){
            this.dao.inserir(salao);
        }
    }
    
    public Salao recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((SalaoHibernateDao)dao).recuperar(codigo);
    }
    
    public Salao recuperarCnpj(Long cnpj){
        if(cnpj == null){
            return null;
        }
        return ((SalaoHibernateDao)dao).recuperarCNPJ(cnpj);
    }
    
    public void alterar(Salao salao){
        if(((SalaoHibernateDao)dao).recuperar(salao.getId_salao()) != null){
            this.dao.alterar(salao);
        }
    }
    
    public void deletar(Salao salao){
        if(((SalaoHibernateDao)dao).recuperar(salao.getId_salao()) != null){
            this.dao.deletar(salao);
        }
    }
    
    public List<Salao> recuperarTodos(){
        return ((SalaoHibernateDao)dao).recuperarTodos();
    }
    
    public boolean login(String login, String senha){
        if(login == null || senha == null){
            return false;
        }
        return ((SalaoHibernateDao)dao).login(login, senha);
    }
}
