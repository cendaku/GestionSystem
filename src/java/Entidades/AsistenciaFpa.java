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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "asistencia_fpa")
@NamedQueries({
    @NamedQuery(name = "AsistenciaFpa.findAll", query = "SELECT a FROM AsistenciaFpa a")
    , @NamedQuery(name = "AsistenciaFpa.findByCurso", query = "SELECT a FROM AsistenciaFpa a WHERE a.asistenciaFpaPK.curso = :curso")
    , @NamedQuery(name = "AsistenciaFpa.findByAlumno", query = "SELECT a FROM AsistenciaFpa a WHERE a.asistenciaFpaPK.alumno = :alumno")
    , @NamedQuery(name = "AsistenciaFpa.findByFecha", query = "SELECT a FROM AsistenciaFpa a WHERE a.asistenciaFpaPK.fecha = :fecha")
    , @NamedQuery(name = "AsistenciaFpa.findByPresencia", query = "SELECT a FROM AsistenciaFpa a WHERE a.presencia = :presencia")})
public class AsistenciaFpa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaFpaPK asistenciaFpaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presencia")
    private boolean presencia;
    @JoinColumns({
        @JoinColumn(name = "curso", referencedColumnName = "curso", insertable = false, updatable = false)
        , @JoinColumn(name = "alumno", referencedColumnName = "alumno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private InscripcionFpa inscripcionFpa;

    public AsistenciaFpa() {
    }

    public AsistenciaFpa(AsistenciaFpaPK asistenciaFpaPK) {
        this.asistenciaFpaPK = asistenciaFpaPK;
    }

    public AsistenciaFpa(AsistenciaFpaPK asistenciaFpaPK, boolean presencia) {
        this.asistenciaFpaPK = asistenciaFpaPK;
        this.presencia = presencia;
    }

    public AsistenciaFpa(int curso, int alumno, Date fecha) {
        this.asistenciaFpaPK = new AsistenciaFpaPK(curso, alumno, fecha);
    }

    public AsistenciaFpaPK getAsistenciaFpaPK() {
        return asistenciaFpaPK;
    }

    public void setAsistenciaFpaPK(AsistenciaFpaPK asistenciaFpaPK) {
        this.asistenciaFpaPK = asistenciaFpaPK;
    }

    public boolean getPresencia() {
        return presencia;
    }

    public void setPresencia(boolean presencia) {
        this.presencia = presencia;
    }

    public InscripcionFpa getInscripcionFpa() {
        return inscripcionFpa;
    }

    public void setInscripcionFpa(InscripcionFpa inscripcionFpa) {
        this.inscripcionFpa = inscripcionFpa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaFpaPK != null ? asistenciaFpaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaFpa)) {
            return false;
        }
        AsistenciaFpa other = (AsistenciaFpa) object;
        if ((this.asistenciaFpaPK == null && other.asistenciaFpaPK != null) || (this.asistenciaFpaPK != null && !this.asistenciaFpaPK.equals(other.asistenciaFpaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsistenciaFpa[ asistenciaFpaPK=" + asistenciaFpaPK + " ]";
    }
    
}
