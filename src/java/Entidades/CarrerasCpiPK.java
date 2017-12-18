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
public class CarrerasCpiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cpi_anho")
    private int cpiAnho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpi_numero_nacional")
    private int cpiNumeroNacional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carrera")
    private int carrera;

    public CarrerasCpiPK() {
    }

    public CarrerasCpiPK(int cpiAnho, int cpiNumeroNacional, int carrera) {
        this.cpiAnho = cpiAnho;
        this.cpiNumeroNacional = cpiNumeroNacional;
        this.carrera = carrera;
    }

    public int getCpiAnho() {
        return cpiAnho;
    }

    public void setCpiAnho(int cpiAnho) {
        this.cpiAnho = cpiAnho;
    }

    public int getCpiNumeroNacional() {
        return cpiNumeroNacional;
    }

    public void setCpiNumeroNacional(int cpiNumeroNacional) {
        this.cpiNumeroNacional = cpiNumeroNacional;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cpiAnho;
        hash += (int) cpiNumeroNacional;
        hash += (int) carrera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrerasCpiPK)) {
            return false;
        }
        CarrerasCpiPK other = (CarrerasCpiPK) object;
        if (this.cpiAnho != other.cpiAnho) {
            return false;
        }
        if (this.cpiNumeroNacional != other.cpiNumeroNacional) {
            return false;
        }
        if (this.carrera != other.carrera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarrerasCpiPK[ cpiAnho=" + cpiAnho + ", cpiNumeroNacional=" + cpiNumeroNacional + ", carrera=" + carrera + " ]";
    }
    
}
