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
public class HorarioInstructoritsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "horario")
    private int horario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor")
    private int instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_its")
    private int materiaIts;

    public HorarioInstructoritsPK() {
    }

    public HorarioInstructoritsPK(int horario, int instructor, int materiaIts) {
        this.horario = horario;
        this.instructor = instructor;
        this.materiaIts = materiaIts;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
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
        hash += (int) horario;
        hash += (int) instructor;
        hash += (int) materiaIts;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioInstructoritsPK)) {
            return false;
        }
        HorarioInstructoritsPK other = (HorarioInstructoritsPK) object;
        if (this.horario != other.horario) {
            return false;
        }
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
        return "Entidades.HorarioInstructoritsPK[ horario=" + horario + ", instructor=" + instructor + ", materiaIts=" + materiaIts + " ]";
    }
    
}
