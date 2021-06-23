/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.ImplDao;
import dao.ImplMunicipioDao;

/**
 *
 * @author yagov
 */
public class ServiceLocator {
    
    public static ImplDao getEstadoDao() {
      return new ImplDao();
    }
    
    public static ImplMunicipioDao getMunicipioDao() {
      return new ImplMunicipioDao();
    }
    
}
