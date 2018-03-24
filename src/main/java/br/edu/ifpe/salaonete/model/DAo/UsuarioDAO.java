/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.DAo;

import br.edu.ifpe.salaonete.model.entidade.Usuario;

/**
 *
 * @author wemerson
 */
public interface UsuarioDAO extends DAO<Usuario>{
    
    public void recuperarCPF(long cpf);
    
}
