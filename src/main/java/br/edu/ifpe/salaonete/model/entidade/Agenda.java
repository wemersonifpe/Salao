/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author wemerson
 */
@Entity
public class Agenda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_agenda;
    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuarios;
    @Column(name = "data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "horario")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horario;

    public Agenda() {
        this.usuarios = new Usuario();
    }

    public Agenda(Date data, Date horario) {
        this.data = data;
        this.horario = horario;
    }

    public Agenda(Usuario usuarios, Date data, Date horario) {
        this.usuarios = usuarios;
        this.data = data;
        this.horario = horario;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    
    
    
}
