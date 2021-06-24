/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Rigolon
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {
    
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMunicipio;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "populacao", nullable = false)
    private int populacao;

    @Column(name = "clima", length = 11, nullable = true)
    private String clima;

    @Column(name = "gastos", nullable = false)
    private float gastos;
    
    @ManyToOne 
    @JoinColumn(name = "idEstado") 
    private Estados estado;

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Municipio(Long idMunicipio, String nome, int populacao, String clima, float gastos, Estados estado) {
        this.idMunicipio = idMunicipio;
        this.nome = nome;
        this.populacao = populacao;
        this.clima = clima;
        this.gastos = gastos;
        this.estado = estado;
    }
    

    
    
    
    

    public Municipio() {
    }





    public Long getId() {
        return idMunicipio;
    }

    public void setId(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Estados[ id=" + idMunicipio + " ]";
    }
    
    
    
}
