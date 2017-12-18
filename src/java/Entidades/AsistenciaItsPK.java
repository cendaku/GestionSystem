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
public class AsistenciaItsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    private int hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sem_habi_num")
    private int semHabiNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sem_habi_anho")
    private int semHabiAnho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo")
    private int grupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carrera")
    private int carrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private int alumno;
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

    public AsistenciaItsPK(Date fecha, int hora, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre, int alumno, int contratoInstructorits, int materiaIts) {
        this.fecha = fecha;
        this.hora = hora;
        this.semHabiNum = semHabiNum;
        this.semHabiAnho = semHabiAnho;
        this.grupo = grupo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.alumno = alumno;
        this.contratoInstructorits = contratoInstructorits;
        this.materiaIts = materiaIts;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getSemHabiNum() {
        return semHabiNum;
    }

    public void setSemHabiNum(int semHabiNum) {
        this.semHabiNum = semHabiNum;
    }

    public int getSemHabiAnho() {
        return semHabiAnho;
    }

    public void setSemHabiAnho(int semHabiAnho) {
        this.semHabiAnho = semHabiAnho;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
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
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) hora;
        hash += (int) semHabiNum;
        hash += (int) semHabiAnho;
        hash += (int) grupo;
        hash += (int) carrera;
        hash += (int) semestre;
        hash += (int) alumno;
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
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        if (this.semHabiNum != other.semHabiNum) {
            return false;
        }
        if (this.semHabiAnho != other.semHabiAnho) {
            return false;
        }
        if (this.grupo != other.grupo) {
            return false;
        }
        if (this.carrera != other.carrera) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        if (this.alumno != other.alumno) {
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
        return "Entidades.AsistenciaItsPK[ fecha=" + fecha + ", hora=" + hora + ", semHabiNum=" + semHabiNum + ", semHabiAnho=" + semHabiAnho + ", grupo=" + grupo + ", carrera=" + carrera + ", semestre=" + semestre + ", alumno=" + alumno + ", contratoInstructorits=" + contratoInstructorits + ", materiaIts=" + materiaIts + " ]";
    }
    
}
