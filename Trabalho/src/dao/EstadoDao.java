/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dominio.Estados;
import java.util.List;


/**
 *
 * @author yagov
 */
public interface EstadoDao {
    
    void excluir(Estados estado);
   
    List<Estados> pesquisar(Estados estado);
    
    void salvarAtualizar(Estados estado);
    
}
