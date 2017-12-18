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
public class InscripcionCpiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private int alumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpi_anho")
    private int cpiAnho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpi_num")
    private int cpiNum;

    public InscripcionCpiPK() {
    }

    public InscripcionCpiPK(int alumno, int cpiAnho, int cpiNum) {
        this.alumno = alumno;
        this.cpiAnho = cpiAnho;
        this.cpiNum = cpiNum;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getCpiAnho() {
        return cpiAnho;
    }

    public void setCpiAnho(int cpiAnho) {
        this.cpiAnho = cpiAnho;
    }

    public int getCpiNum() {
        return cpiNum;
    }

    public void setCpiNum(int cpiNum) {
        this.cpiNum = cpiNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumno;
        hash += (int) cpiAnho;
        hash += (int) cpiNum;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionCpiPK)) {
            return false;
        }
        InscripcionCpiPK other = (InscripcionCpiPK) object;
        if (this.alumno != other.alumno) {
            return false;
        }
        if (this.cpiAnho != other.cpiAnho) {
            return false;
        }
        if (this.cpiNum != other.cpiNum) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionCpiPK[ alumno=" + alumno + ", cpiAnho=" + cpiAnho + ", cpiNum=" + cpiNum + " ]";
    }
    
}
