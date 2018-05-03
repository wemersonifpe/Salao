/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wemerson
 */
@Entity
public class AgendaServicos implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "cod_servico", referencedColumnName = "id_servico", nullable = false)
    private Servicos servico;
    @ManyToOne
    @JoinColumn(name = "cod_agenda", referencedColumnName = "id_agenda", nullable = false)
    private Agenda agenda;

    public AgendaServicos() {
    }

    public AgendaServicos(Servicos servico, Agenda agenda) {
        this.servico = servico;
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    
}
