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
public class ContratoInstructorcpiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor")
    private int instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia")
    private int materia;

    public ContratoInstructorcpiPK() {
    }

    public ContratoInstructorcpiPK(int instructor, int materia) {
        this.instructor = instructor;
        this.materia = materia;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) instructor;
        hash += (int) materia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoInstructorcpiPK)) {
            return false;
        }
        ContratoInstructorcpiPK other = (ContratoInstructorcpiPK) object;
        if (this.instructor != other.instructor) {
            return false;
        }
        if (this.materia != other.materia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoInstructorcpiPK[ instructor=" + instructor + ", materia=" + materia + " ]";
    }
    
}
