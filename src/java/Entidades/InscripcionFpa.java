/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "inscripcion_fpa")
@NamedQueries({
    @NamedQuery(name = "InscripcionFpa.findAll", query = "SELECT i FROM InscripcionFpa i")
    , @NamedQuery(name = "InscripcionFpa.findByCurso", query = "SELECT i FROM InscripcionFpa i WHERE i.inscripcionFpaPK.curso = :curso")
    , @NamedQuery(name = "InscripcionFpa.findByAlumno", query = "SELECT i FROM InscripcionFpa i WHERE i.inscripcionFpaPK.alumno = :alumno")
    , @NamedQuery(name = "InscripcionFpa.findByCulminado", query = "SELECT i FROM InscripcionFpa i WHERE i.culminado = :culminado")
    , @NamedQuery(name = "InscripcionFpa.findByFechaInscripcion", query = "SELECT i FROM InscripcionFpa i WHERE i.fechaInscripcion = :fechaInscripcion")})
public class InscripcionFpa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionFpaPK inscripcionFpaPK;
    @Column(name = "culminado")
    private Boolean culminado;
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionFpa")
    private List<AsistenciaFpa> asistenciaFpaList;
    @JoinColumn(name = "alumno", referencedColumnName = "ci", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno1;
    @JoinColumn(name = "curso", referencedColumnName = "numero_nacional", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionFpa")
    private List<Certificado> certificadoList;

    public InscripcionFpa() {
    }

    public InscripcionFpa(InscripcionFpaPK inscripcionFpaPK) {
        this.inscripcionFpaPK = inscripcionFpaPK;
    }

    public InscripcionFpa(int curso, int alumno) {
        this.inscripcionFpaPK = new InscripcionFpaPK(curso, alumno);
    }

    public InscripcionFpaPK getInscripcionFpaPK() {
        return inscripcionFpaPK;
    }

    public void setInscripcionFpaPK(InscripcionFpaPK inscripcionFpaPK) {
        this.inscripcionFpaPK = inscripcionFpaPK;
    }

    public Boolean getCulminado() {
        return culminado;
    }

    public void setCulminado(Boolean culminado) {
        this.culminado = culminado;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public List<AsistenciaFpa> getAsistenciaFpaList() {
        return asistenciaFpaList;
    }

    public void setAsistenciaFpaList(List<AsistenciaFpa> asistenciaFpaList) {
        this.asistenciaFpaList = asistenciaFpaList;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
    }

    public Curso getCurso1() {
        return curso1;
    }

    public void setCurso1(Curso curso1) {
        this.curso1 = curso1;
    }

    public List<Certificado> getCertificadoList() {
        return certificadoList;
    }

    public void setCertificadoList(List<Certificado> certificadoList) {
        this.certificadoList = certificadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionFpaPK != null ? inscripcionFpaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionFpa)) {
            return false;
        }
        InscripcionFpa other = (InscripcionFpa) object;
        if ((this.inscripcionFpaPK == null && other.inscripcionFpaPK != null) || (this.inscripcionFpaPK != null && !this.inscripcionFpaPK.equals(other.inscripcionFpaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionFpa[ inscripcionFpaPK=" + inscripcionFpaPK + " ]";
    }
    
}
