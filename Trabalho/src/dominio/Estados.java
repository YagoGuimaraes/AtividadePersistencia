/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author yagov
 */
@Entity 
@Table (name="Estado")
public class Estados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nome", length = 63, nullable = false)
    private String nome;
    
    @Column(name="sigla", length = 2, nullable = false)
    private String sigla;
    
    @Column(name="df",  nullable = true)
    private boolean df;
    
    @Column(name="orcamento_total", nullable = false)
    private float orcamentoTotal;
    
    @Column(name="gasto_totais", nullable = false)
    private float gastoTotais;


    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public boolean isDf() {
        return df;
    }

    public void setDf(boolean df) {
        this.df = df;
    }

    public float getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(float orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public float getGastoTotais() {
        return gastoTotais;
    }

    public void setGastoTotais(float gastoTotais) {
        this.gastoTotais = gastoTotais;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Estados[ id=" + id + " ]";
    }
    
}
