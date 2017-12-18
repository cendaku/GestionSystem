/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Embeddable
public class PdCpiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "anho")
    private int anho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_nacional")
    private int numeroNacional;

    public PdCpiPK() {
    }

    public PdCpiPK(int anho, int numeroNacional) {
        this.anho = anho;
        this.numeroNacional = numeroNacional;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getNumeroNacional() {
        return numeroNacional;
    }

    public void setNumeroNacional(int numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anho;
        hash += (int) numeroNacional;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PdCpiPK)) {
            return false;
        }
        PdCpiPK other = (PdCpiPK) object;
        if (this.anho != other.anho) {
            return false;
        }
        if (this.numeroNacional != other.numeroNacional) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PdCpiPK[ anho=" + anho + ", numeroNacional=" + numeroNacional + " ]";
    }
    
}
