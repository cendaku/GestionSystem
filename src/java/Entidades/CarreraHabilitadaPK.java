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
public class CarreraHabilitadaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo")
    private int grupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carrera")
    private int carrera;

    public CarreraHabilitadaPK() {
    }

    public CarreraHabilitadaPK(int grupo, int carrera) {
        this.grupo = grupo;
        this.carrera = carrera;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) grupo;
        hash += (int) carrera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarreraHabilitadaPK)) {
            return false;
        }
        CarreraHabilitadaPK other = (CarreraHabilitadaPK) object;
        if (this.grupo != other.grupo) {
            return false;
        }
        if (this.carrera != other.carrera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarreraHabilitadaPK[ grupo=" + grupo + ", carrera=" + carrera + " ]";
    }
    
}
