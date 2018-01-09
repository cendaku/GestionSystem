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
public class AsistenciaItsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrato_instructorits")
    private int contratoInstructorits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_its")
    private int materiaIts;

    public AsistenciaItsPK() {
    }

    public AsistenciaItsPK(int id, int contratoInstructorits, int materiaIts) {
        this.id = id;
        this.contratoInstructorits = contratoInstructorits;
        this.materiaIts = materiaIts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContratoInstructorits() {
        return contratoInstructorits;
    }

    public void setContratoInstructorits(int contratoInstructorits) {
        this.contratoInstructorits = contratoInstructorits;
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
        hash += (int) id;
        hash += (int) contratoInstructorits;
        hash += (int) materiaIts;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaItsPK)) {
            return false;
        }
        AsistenciaItsPK other = (AsistenciaItsPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.contratoInstructorits != other.contratoInstructorits) {
            return false;
        }
        if (this.materiaIts != other.materiaIts) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsistenciaItsPK[ id=" + id + ", contratoInstructorits=" + contratoInstructorits + ", materiaIts=" + materiaIts + " ]";
    }
    
}
