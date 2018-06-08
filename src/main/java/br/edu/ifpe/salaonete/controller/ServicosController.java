/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Servicos;
import br.edu.ifpe.salaonete.model.negocio.ServicosModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class ServicosController {
    
    private ServicosModel servicosNegocio;
    private Servicos servico;
    
    public ServicosController(){
        this.servicosNegocio = new ServicosModel();
        this.servico = new Servicos();
    }
    
    public void cadastar(){
        this.servicosNegocio.cadastrar(servico);
        this.servico = new Servicos();
    }
    
    public Servicos recuperar(Integer codigo){
        return this.servicosNegocio.recuperar(codigo);
    }
    
    public String alterar(Servicos servicos){
        this.servicosNegocio.alterar(servicos);
        return "";
    }
    
    public void deletar(Servicos servicos){
        this.servicosNegocio.deletar(servicos);
    }
    
    public List<Servicos> recuperarTodos(){
        return this.servicosNegocio.recuperarTodos();
    }

    public ServicosModel getServicosNegocio() {
        return servicosNegocio;
    }

    public void setServicosNegocio(ServicosModel servicosNegocio) {
        this.servicosNegocio = servicosNegocio;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }
    
}
