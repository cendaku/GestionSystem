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
public class InscripcionFpaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "curso")
    private int curso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private int alumno;

    public InscripcionFpaPK() {
    }

    public InscripcionFpaPK(int curso, int alumno) {
        this.curso = curso;
        this.alumno = alumno;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) curso;
        hash += (int) alumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionFpaPK)) {
            return false;
        }
        InscripcionFpaPK other = (InscripcionFpaPK) object;
        if (this.curso != other.curso) {
            return false;
        }
        if (this.alumno != other.alumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionFpaPK[ curso=" + curso + ", alumno=" + alumno + " ]";
    }
    
}
