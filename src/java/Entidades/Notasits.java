/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "notasits")
@NamedQueries({
    @NamedQuery(name = "Notasits.findAll", query = "SELECT n FROM Notasits n")
    , @NamedQuery(name = "Notasits.findByParcial1", query = "SELECT n FROM Notasits n WHERE n.parcial1 = :parcial1")
    , @NamedQuery(name = "Notasits.findByParcial2", query = "SELECT n FROM Notasits n WHERE n.parcial2 = :parcial2")
    , @NamedQuery(name = "Notasits.findByFinal1", query = "SELECT n FROM Notasits n WHERE n.final1 = :final1")
    , @NamedQuery(name = "Notasits.findByRecuperatorio", query = "SELECT n FROM Notasits n WHERE n.recuperatorio = :recuperatorio")
    , @NamedQuery(name = "Notasits.findByObservacion", query = "SELECT n FROM Notasits n WHERE n.observacion = :observacion")
    , @NamedQuery(name = "Notasits.findByNota", query = "SELECT n FROM Notasits n WHERE n.nota = :nota")
    , @NamedQuery(name = "Notasits.findByInstructor", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.instructor = :instructor")
    , @NamedQuery(name = "Notasits.findByMateria", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.materia = :materia")
    , @NamedQuery(name = "Notasits.findByAlumno", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.alumno = :alumno")
    , @NamedQuery(name = "Notasits.findBySemHabiNum", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.semHabiNum = :semHabiNum")
    , @NamedQuery(name = "Notasits.findBySemHabiAnho", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.semHabiAnho = :semHabiAnho")
    , @NamedQuery(name = "Notasits.findByGrupo", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.grupo = :grupo")
    , @NamedQuery(name = "Notasits.findByCarrera", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.carrera = :carrera")
    , @NamedQuery(name = "Notasits.findBySemestre", query = "SELECT n FROM Notasits n WHERE n.notasitsPK.semestre = :semestre")})
public class Notasits implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasitsPK notasitsPK;
    @Column(name = "parcial1")
    private Integer parcial1;
    @Column(name = "parcial2")
    private Integer parcial2;
    @Column(name = "final")
    private Integer final1;
    @Column(name = "recuperatorio")
    private Integer recuperatorio;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "nota")
    private Integer nota;
    @JoinColumns({
        @JoinColumn(name = "instructor", referencedColumnName = "instructor", insertable = false, updatable = false)
        , @JoinColumn(name = "materia", referencedColumnName = "materia_its", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ContratoInstructorits contratoInstructorits;
    @JoinColumns({
        @JoinColumn(name = "alumno", referencedColumnName = "alumno", insertable = false, updatable = false)
        , @JoinColumn(name = "sem_habi_num", referencedColumnName = "sem_habi_num", insertable = false, updatable = false)
        , @JoinColumn(name = "sem_habi_anho", referencedColumnName = "sem_habi_anho", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo", referencedColumnName = "grupo", insertable = false, updatable = false)
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera", insertable = false, updatable = false)
        , @JoinColumn(name = "semestre", referencedColumnName = "semestre", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private InscripcionIts inscripcionIts;

    public Notasits() {
        this.contratoInstructorits = new ContratoInstructorits();
        this.inscripcionIts = new InscripcionIts();
        this.notasitsPK = new NotasitsPK();
    }

    public Notasits(NotasitsPK notasitsPK) {
        this.notasitsPK = notasitsPK;
    }

    public Notasits(int instructor, int materia, int alumno, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre) {
        this.notasitsPK = new NotasitsPK(instructor, materia, alumno, semHabiNum, semHabiAnho, grupo, carrera, semestre);
    }

    public NotasitsPK getNotasitsPK() {
        return notasitsPK;
    }

    public void setNotasitsPK(NotasitsPK notasitsPK) {
        this.notasitsPK = notasitsPK;
    }

    public Integer getParcial1() {
        return parcial1;
    }

    public void setParcial1(Integer parcial1) {
        this.parcial1 = parcial1;
    }

    public Integer getParcial2() {
        return parcial2;
    }

    public void setParcial2(Integer parcial2) {
        this.parcial2 = parcial2;
    }

    public Integer getFinal1() {
        return final1;
    }

    public void setFinal1(Integer final1) {
        this.final1 = final1;
    }

    public Integer getRecuperatorio() {
        return recuperatorio;
    }

    public void setRecuperatorio(Integer recuperatorio) {
        this.recuperatorio = recuperatorio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public ContratoInstructorits getContratoInstructorits() {
        return contratoInstructorits;
    }

    public void setContratoInstructorits(ContratoInstructorits contratoInstructorits) {
        this.contratoInstructorits = contratoInstructorits;
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
        hash += (notasitsPK != null ? notasitsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notasits)) {
            return false;
        }
        Notasits other = (Notasits) object;
        if ((this.notasitsPK == null && other.notasitsPK != null) || (this.notasitsPK != null && !this.notasitsPK.equals(other.notasitsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Notasits[ notasitsPK=" + notasitsPK + " ]";
    }
    
}
