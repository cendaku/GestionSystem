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
public class TrabajoPracticoitsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor")
    private int instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_its")
    private int materiaIts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private int alumno;
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

    public TrabajoPracticoitsPK() {
    }

    public TrabajoPracticoitsPK(int instructor, int materiaIts, int alumno, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre) {
        this.instructor = instructor;
        this.materiaIts = materiaIts;
        this.alumno = alumno;
        this.semHabiNum = semHabiNum;
        this.semHabiAnho = semHabiAnho;
        this.grupo = grupo;
        this.carrera = carrera;
        this.semestre = semestre;
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

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) instructor;
        hash += (int) materiaIts;
        hash += (int) alumno;
        hash += (int) semHabiNum;
        hash += (int) semHabiAnho;
        hash += (int) grupo;
        hash += (int) carrera;
        hash += (int) semestre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajoPracticoitsPK)) {
            return false;
        }
        TrabajoPracticoitsPK other = (TrabajoPracticoitsPK) object;
        if (this.instructor != other.instructor) {
            return false;
        }
        if (this.materiaIts != other.materiaIts) {
            return false;
        }
        if (this.alumno != other.alumno) {
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
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TrabajoPracticoitsPK[ instructor=" + instructor + ", materiaIts=" + materiaIts + ", alumno=" + alumno + ", semHabiNum=" + semHabiNum + ", semHabiAnho=" + semHabiAnho + ", grupo=" + grupo + ", carrera=" + carrera + ", semestre=" + semestre + " ]";
    }
    
}
