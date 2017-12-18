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
public class SemestreHabilitadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_nacional")
    private int numeroNacional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anho")
    private int anho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo")
    private int grupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carrera")
    private int carrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;

    public SemestreHabilitadoPK() {
    }

    public SemestreHabilitadoPK(int numeroNacional, int anho, int grupo, int carrera, int semestre) {
        this.numeroNacional = numeroNacional;
        this.anho = anho;
        this.grupo = grupo;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public int getNumeroNacional() {
        return numeroNacional;
    }

    public void setNumeroNacional(int numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroNacional;
        hash += (int) anho;
        hash += (int) grupo;
        hash += (int) carrera;
        hash += (int) semestre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemestreHabilitadoPK)) {
            return false;
        }
        SemestreHabilitadoPK other = (SemestreHabilitadoPK) object;
        if (this.numeroNacional != other.numeroNacional) {
            return false;
        }
        if (this.anho != other.anho) {
            return false;
        }
        if (this.grupo != other.grupo) {
            return false;
        }
        if (this.carrera != other.carrera) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SemestreHabilitadoPK[ numeroNacional=" + numeroNacional + ", anho=" + anho + ", grupo=" + grupo + ", carrera=" + carrera + ", semestre=" + semestre + " ]";
    }
    
}
