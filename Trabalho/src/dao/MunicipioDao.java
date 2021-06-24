/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Municipio;
import java.util.List;

/**
 *
 * @author Gabriel Rigolon
 */
public interface MunicipioDao {
    
    void excluir(Municipio municipio);
   
    List<Municipio> pesquisar(Municipio municipio);
    
    void salvarAtualizar(Municipio municipio);
    
    List<Municipio> pesquisarPorClima(Municipio municipio);
}
