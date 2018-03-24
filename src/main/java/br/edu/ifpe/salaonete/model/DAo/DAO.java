/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salaonete.model.DAo;

import java.util.List;

/**
 *
 * @author wemerson
 */
public interface DAO<T> {
    
    public void inserir(T t);
    public void alterar(T t);
    public T recuperar(int codigo);
    public void deletar(T t);
    public List<T> recuperarTodos();
    
}
