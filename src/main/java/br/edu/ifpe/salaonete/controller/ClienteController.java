/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.controller;

import br.edu.ifpe.salaonete.model.entidade.ClienteSalao;
import br.edu.ifpe.salaonete.model.negocio.ClienteModel;

/**
 *
 * @author wemerson
 */
public class ClienteController {
    
    private final ClienteModel clienteModel;
    private ClienteSalao cliente;
    
    public ClienteController(){
        this.clienteModel = new ClienteModel();
        this.cliente = new ClienteSalao();
    }
    
}
