/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "inscripcion_its")
@NamedQueries({
    @NamedQuery(name = "InscripcionIts.findAll", query = "SELECT i FROM InscripcionIts i")
    , @NamedQuery(name = "InscripcionIts.findByAlumno", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.alumno = :alumno")
    , @NamedQuery(name = "InscripcionIts.findBySemHabiNum", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.semHabiNum = :semHabiNum")
    , @NamedQuery(name = "InscripcionIts.findBySemHabiAnho", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.semHabiAnho = :semHabiAnho")
    , @NamedQuery(name = "InscripcionIts.findByGrupo", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.grupo = :grupo")
    , @NamedQuery(name = "InscripcionIts.findByCarrera", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.carrera = :carrera")
    , @NamedQuery(name = "InscripcionIts.findBySemestre", query = "SELECT i FROM InscripcionIts i WHERE i.inscripcionItsPK.semestre = :semestre")})
public class InscripcionIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionItsPK inscripcionItsPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionIts")
    private List<AsistenciaIts> asistenciaItsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionIts")
    private List<Notasits> notasitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionIts")
    private List<TrabajoPracticoits> trabajoPracticoitsList;
    @JoinColumns({
        @JoinColumn(name = "sem_habi_num", referencedColumnName = "numero_nacional", insertable = false, updatable = false)
        , @JoinColumn(name = "sem_habi_anho", referencedColumnName = "anho", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo", referencedColumnName = "grupo", insertable = false, updatable = false)
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera", insertable = false, updatable = false)
        , @JoinColumn(name = "semestre", referencedColumnName = "semestre", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SemestreHabilitado semestreHabilitado;
    @JoinColumn(name = "alumno", referencedColumnName = "ci", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno1;

    public InscripcionIts() {
    }

    public InscripcionIts(InscripcionItsPK inscripcionItsPK) {
        this.inscripcionItsPK = inscripcionItsPK;
    }

    public InscripcionIts(int alumno, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre) {
        this.inscripcionItsPK = new InscripcionItsPK(alumno, semHabiNum, semHabiAnho, grupo, carrera, semestre);
    }

    public InscripcionItsPK getInscripcionItsPK() {
        return inscripcionItsPK;
    }

    public void setInscripcionItsPK(InscripcionItsPK inscripcionItsPK) {
        this.inscripcionItsPK = inscripcionItsPK;
    }

    public List<AsistenciaIts> getAsistenciaItsList() {
        return asistenciaItsList;
    }

    public void setAsistenciaItsList(List<AsistenciaIts> asistenciaItsList) {
        this.asistenciaItsList = asistenciaItsList;
    }

    public List<Notasits> getNotasitsList() {
        return notasitsList;
    }

    public void setNotasitsList(List<Notasits> notasitsList) {
        this.notasitsList = notasitsList;
    }

    public List<TrabajoPracticoits> getTrabajoPracticoitsList() {
        return trabajoPracticoitsList;
    }

    public void setTrabajoPracticoitsList(List<TrabajoPracticoits> trabajoPracticoitsList) {
        this.trabajoPracticoitsList = trabajoPracticoitsList;
    }

    public SemestreHabilitado getSemestreHabilitado() {
        return semestreHabilitado;
    }

    public void setSemestreHabilitado(SemestreHabilitado semestreHabilitado) {
        this.semestreHabilitado = semestreHabilitado;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionItsPK != null ? inscripcionItsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionIts)) {
            return false;
        }
        InscripcionIts other = (InscripcionIts) object;
        if ((this.inscripcionItsPK == null && other.inscripcionItsPK != null) || (this.inscripcionItsPK != null && !this.inscripcionItsPK.equals(other.inscripcionItsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionIts[ inscripcionItsPK=" + inscripcionItsPK + " ]";
    }
    
}
