/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.view;

import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.hibernate.SalaoHibernateDao;


/**
 *
 * @author wemerson
 */
public class teste {
    public static void main(String[] args) {
        Salao sal = new Salao();
        sal.setCnpj(123);
        sal.setNome("EspacoHear");
        
        SalaoHibernateDao con = new SalaoHibernateDao();
        
        con.inserir(sal);
    }
    
}
