/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.hibernate;

import br.edu.ifpe.salaonete.model.entidade.Endereco;
import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.negocio.SalaoModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wemerson
 */
public class SalaoHibernateDaoTest {
    
    public SalaoHibernateDaoTest() {
    }

    @Test
    public void salvar() {
        
        Salao sal = new Salao();
        sal.setCnpj(123);
        sal.setNome("EspacoHear");
        
        SalaoHibernateDao con = new SalaoHibernateDao();
        
        con.inserir(sal);
    }
    
}
