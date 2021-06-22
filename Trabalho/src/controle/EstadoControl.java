/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.EstadoDao;
import dominio.Estados;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import servico.ServiceLocator;



/**
 *
 * @author yagov
 */
public class EstadoControl {
    
    private final PropertyChangeSupport pcs= new PropertyChangeSupport(this);
    private Estados estadoDigitado;
    private Estados estadoselecionado;
    private List<Estados> estadoTabela;
    private  EstadoDao estadodao;

    
    
    public Estados getEstadoDigitado() {
        return estadoDigitado;
    }
    
    
    public void setEstadoDigitado(Estados estadoDigitado) {
        Estados oldEstadoDigitado=this.estadoDigitado;
        this.estadoDigitado=estadoDigitado;
        pcs.firePropertyChange("estadoDigitado", oldEstadoDigitado, estadoDigitado);  
    }
    
     public Estados getEstadoselecionado() {
        return estadoselecionado;
    }

    public void setEstadoselecionado(Estados estadoselecionado) {
        
        
        if (this.estadoselecionado !=null) {
            setEstadoselecionado(estadoselecionado);
        }
        this.estadoselecionado=estadoselecionado;
        
    }

    public List<Estados> getEstadosTabela() {
        return estadoTabela;
    }

    public void setEstadosTabela(List<Estados> estadoTabela) {
        this.estadoTabela = estadoTabela;
    }
    

    
    public EstadoControl(){
        estadodao = ServiceLocator.getEstadoDao();  
        estadoTabela = ObservableCollections.observableList
        (new ArrayList<Estados>());
        novo();
        pesquisar();     
    }

    public void novo() {
        setEstadoDigitado(new Estados());
    }

    public void pesquisar() {
       estadoTabela.clear();
        estadoTabela.addAll(estadodao.pesquisar(estadoDigitado)); 
    }
    
    public void salvar(){
       estadodao.salvarAtualizar(estadoDigitado);
        novo();
        pesquisar();   
    }
   
    public void excluir(){
        estadodao.excluir(estadoDigitado);
        novo();
        pesquisar();   
        
    }
    
    
    
    
    public void addPropertyChangeListener(PropertyChangeListener e)  {
      pcs.addPropertyChangeListener(e);
      
  }
    
    public void removePropertyChangeListener(PropertyChangeListener e)  {
      pcs.removePropertyChangeListener(e);
      
  }
    
    
    
}
