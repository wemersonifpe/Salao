/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.Salao;
import br.edu.ifpe.salaonete.model.negocio.SalaoModel;

/**
 *
 * @author wemerson
 */
public class ClienteController {
    
    private final SalaoModel clienteModel;
    private Salao cliente;
    
    public ClienteController(){
        this.clienteModel = new SalaoModel();
        this.cliente = new Salao();
    }
    
}
