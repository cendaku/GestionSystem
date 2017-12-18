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
public class ContratoInstructoritsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor")
    private int instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_its")
    private int materiaIts;

    public ContratoInstructoritsPK() {
    }

    public ContratoInstructoritsPK(int instructor, int materiaIts) {
        this.instructor = instructor;
        this.materiaIts = materiaIts;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public int getMateriaIts() {
        return materiaIts;
    }

    public void setMateriaIts(int materiaIts) {
        this.materiaIts = materiaIts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) instructor;
        hash += (int) materiaIts;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoInstructoritsPK)) {
            return false;
        }
        ContratoInstructoritsPK other = (ContratoInstructoritsPK) object;
        if (this.instructor != other.instructor) {
            return false;
        }
        if (this.materiaIts != other.materiaIts) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoInstructoritsPK[ instructor=" + instructor + ", materiaIts=" + materiaIts + " ]";
    }
    
}
