/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "asistencia_its")
@NamedQueries({
    @NamedQuery(name = "AsistenciaIts.findAll", query = "SELECT a FROM AsistenciaIts a")
    , @NamedQuery(name = "AsistenciaIts.findByFecha", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.fecha = :fecha")
    , @NamedQuery(name = "AsistenciaIts.findByHora", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.hora = :hora")
    , @NamedQuery(name = "AsistenciaIts.findBySemHabiNum", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.semHabiNum = :semHabiNum")
    , @NamedQuery(name = "AsistenciaIts.findBySemHabiAnho", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.semHabiAnho = :semHabiAnho")
    , @NamedQuery(name = "AsistenciaIts.findByGrupo", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.grupo = :grupo")
    , @NamedQuery(name = "AsistenciaIts.findByCarrera", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.carrera = :carrera")
    , @NamedQuery(name = "AsistenciaIts.findBySemestre", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.semestre = :semestre")
    , @NamedQuery(name = "AsistenciaIts.findByPresencia", query = "SELECT a FROM AsistenciaIts a WHERE a.presencia = :presencia")
    , @NamedQuery(name = "AsistenciaIts.findByAlumno", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.alumno = :alumno")
    , @NamedQuery(name = "AsistenciaIts.findByContratoInstructorits", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.contratoInstructorits = :contratoInstructorits")
    , @NamedQuery(name = "AsistenciaIts.findByMateriaIts", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.materiaIts = :materiaIts")})
public class AsistenciaIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaItsPK asistenciaItsPK;
    @Column(name = "presencia")
    private Integer presencia;
    @JoinColumns({
        @JoinColumn(name = "contrato_instructorits", referencedColumnName = "instructor", insertable = false, updatable = false)
        , @JoinColumn(name = "materia_its", referencedColumnName = "materia_its", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ContratoInstructorits contratoInstructorits1;
    @JoinColumns({
        @JoinColumn(name = "alumno", referencedColumnName = "alumno", insertable = false, updatable = false)
        , @JoinColumn(name = "sem_habi_num", referencedColumnName = "sem_habi_num", insertable = false, updatable = false)
        , @JoinColumn(name = "sem_habi_anho", referencedColumnName = "sem_habi_anho", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo", referencedColumnName = "grupo", insertable = false, updatable = false)
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera", insertable = false, updatable = false)
        , @JoinColumn(name = "semestre", referencedColumnName = "semestre", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private InscripcionIts inscripcionIts;

    public AsistenciaIts() {
    }

    public AsistenciaIts(AsistenciaItsPK asistenciaItsPK) {
        this.asistenciaItsPK = asistenciaItsPK;
    }

    public AsistenciaIts(Date fecha, int hora, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre, int alumno, int contratoInstructorits, int materiaIts) {
        this.asistenciaItsPK = new AsistenciaItsPK(fecha, hora, semHabiNum, semHabiAnho, grupo, carrera, semestre, alumno, contratoInstructorits, materiaIts);
    }

    public AsistenciaItsPK getAsistenciaItsPK() {
        return asistenciaItsPK;
    }

    public void setAsistenciaItsPK(AsistenciaItsPK asistenciaItsPK) {
        this.asistenciaItsPK = asistenciaItsPK;
    }

    public Integer getPresencia() {
        return presencia;
    }

    public void setPresencia(Integer presencia) {
        this.presencia = presencia;
    }

    public ContratoInstructorits getContratoInstructorits1() {
        return contratoInstructorits1;
    }

    public void setContratoInstructorits1(ContratoInstructorits contratoInstructorits1) {
        this.contratoInstructorits1 = contratoInstructorits1;
    }

    public InscripcionIts getInscripcionIts() {
        return inscripcionIts;
    }

    public void setInscripcionIts(InscripcionIts inscripcionIts) {
        this.inscripcionIts = inscripcionIts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaItsPK != null ? asistenciaItsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaIts)) {
            return false;
        }
        AsistenciaIts other = (AsistenciaIts) object;
        if ((this.asistenciaItsPK == null && other.asistenciaItsPK != null) || (this.asistenciaItsPK != null && !this.asistenciaItsPK.equals(other.asistenciaItsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsistenciaIts[ asistenciaItsPK=" + asistenciaItsPK + " ]";
    }
    
}
