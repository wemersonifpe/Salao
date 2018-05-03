/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.view;

import br.edu.ifpe.salaonete.controller.UsuarioController;
import br.edu.ifpe.salaonete.model.entidade.Agenda;
import br.edu.ifpe.salaonete.model.entidade.Usuario;
import br.edu.ifpe.salaonete.model.hibernate.AgendaHibernateDao;
import br.edu.ifpe.salaonete.model.hibernate.UsuarioHibernateDao;
import java.util.Date;

/**
 *
 * @author wemerson
 */
public class teste {
    public static void main(String[] args) {
        
        UsuarioHibernateDao lh = new UsuarioHibernateDao();
        
        Usuario usu = new Usuario();
        usu.setCpf(123);
        usu.setNome("wemerson");
       
        
        AgendaHibernateDao a = new AgendaHibernateDao();
        Agenda as = new Agenda();
        as.setUsuarios(usu);

    }
    
}
