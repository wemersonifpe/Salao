/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Agenda;
import br.edu.ifpe.salaonete.model.negocio.AgendaModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class AgendaController {
    
    private AgendaModel agendaNegocio;
    private Agenda agena;
    
    public AgendaController(){
        this.agendaNegocio = new AgendaModel();
        this.agena = new Agenda();
    }
    
    public void cadastrar(){
        this.agendaNegocio.cadastrar(agena);
        this.agena = new Agenda();
    }
    
    public Agenda recuperar(Integer codigo){
        return this.agendaNegocio.recuperar(codigo);
    }
    
    public String alterar(Agenda agenda){
        this.agendaNegocio.alterar(agenda);
        return "";
    }
    
    public void deletar(Agenda agenda){
        this.agendaNegocio.deletar(agenda);
    }
    
    public List<Agenda> recuperarTodos(){
        return this.agendaNegocio.recuperarTodos();
    }

    public AgendaModel getAgendaNegocio() {
        return agendaNegocio;
    }

    public void setAgendaNegocio(AgendaModel agendaNegocio) {
        this.agendaNegocio = agendaNegocio;
    }

    public Agenda getAgena() {
        return agena;
    }

    public void setAgena(Agenda agena) {
        this.agena = agena;
    }
    
}
