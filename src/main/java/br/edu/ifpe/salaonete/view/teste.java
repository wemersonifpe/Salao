/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.view;

import br.edu.ifpe.salaonete.controller.UsuarioController;
import br.edu.ifpe.salaonete.model.entidade.Usuario;

/**
 *
 * @author wemerson
 */
public class teste {
    public static void main(String[] args) {
        
        UsuarioController lh =new UsuarioController();
        
        Usuario usu = new Usuario("Wemerson Diogenes", 123456, "wemerson@gmail.com", "2001wds");
        usu.setId(4);
        lh.alterar(usu);
    }
    
}
