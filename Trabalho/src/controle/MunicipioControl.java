/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.MunicipioDao;
import dominio.Estados;
import dominio.Municipio;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import servico.ServiceLocator;

/**
 *
 * @author Gabriel Rigolon
 */
public class MunicipioControl {
    
    private final PropertyChangeSupport pcs= new PropertyChangeSupport(this);
    private Municipio municipioDigitado;
    private Municipio municipioselecionado;
    private List<Municipio> municipioTabela;
    private  MunicipioDao municipiodao;
    private List<Estados> estadoTabela;

    
    
    public Municipio getMunicipioDigitado() {
        return municipioDigitado;
    }
    
    
    public void setMunicipioDigitado(Municipio municipioDigitado) {
        Municipio oldMunicipioDigitado=this.municipioDigitado;
        this.municipioDigitado=municipioDigitado;
        pcs.firePropertyChange("municipioDigitado", oldMunicipioDigitado, municipioDigitado);  
    }
    
     public Municipio getMunicipioselecionado() {
        return municipioselecionado;
    }

    public void setMunicipioselecionado(Municipio municipioselecionado) {
        
        this.municipioselecionado=municipioselecionado;
        if (this.municipioselecionado !=null) {
            setMunicipioDigitado(municipioselecionado);
        }
        
        
    }

    public List<Municipio> getMunicipiosTabela() {
        return municipioTabela;
    }

    public void setMunicipiosTabela(List<Municipio> municipioTabela) {
        this.municipioTabela = municipioTabela;
    }
    
    public List<Estados> getEstadoTabela() {
        return estadoTabela;
    }

    public void setEstadoTabela(List<Estados> estadoTabela) {
        this.estadoTabela = estadoTabela;
    }
    

    
    public MunicipioControl(){
        municipiodao = ServiceLocator.getMunicipioDao();  
        municipioTabela = ObservableCollections.observableList
        (new ArrayList<Municipio>());
        novo();
        pesquisar();     
    }

    public void novo() {
        setMunicipioDigitado(new Municipio());
    }

    public void pesquisar() {
       municipioTabela.clear();
        municipioTabela.addAll(municipiodao.pesquisar(municipioDigitado)); 
    }
    
    public void salvar(){
       municipiodao.salvarAtualizar(municipioDigitado);
        novo();
        pesquisar();   
    }
   
    public void excluir(){
        municipiodao.excluir(municipioDigitado);
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
