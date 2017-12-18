/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Embeddable
public class AsistenciaFpaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "curso")
    private int curso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private int alumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public AsistenciaFpaPK() {
    }

    public AsistenciaFpaPK(int curso, int alumno, Date fecha) {
        this.curso = curso;
        this.alumno = alumno;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) curso;
        hash += (int) alumno;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaFpaPK)) {
            return false;
        }
        AsistenciaFpaPK other = (AsistenciaFpaPK) object;
        if (this.curso != other.curso) {
            return false;
        }
        if (this.alumno != other.alumno) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsistenciaFpaPK[ curso=" + curso + ", alumno=" + alumno + ", fecha=" + fecha + " ]";
    }
    
}
