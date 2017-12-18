/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "trabajo_practicoits")
@NamedQueries({
    @NamedQuery(name = "TrabajoPracticoits.findAll", query = "SELECT t FROM TrabajoPracticoits t")
    , @NamedQuery(name = "TrabajoPracticoits.findByNombre", query = "SELECT t FROM TrabajoPracticoits t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TrabajoPracticoits.findByRuta", query = "SELECT t FROM TrabajoPracticoits t WHERE t.ruta = :ruta")
    , @NamedQuery(name = "TrabajoPracticoits.findByPuntajetotal", query = "SELECT t FROM TrabajoPracticoits t WHERE t.puntajetotal = :puntajetotal")
    , @NamedQuery(name = "TrabajoPracticoits.findByInstructor", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.instructor = :instructor")
    , @NamedQuery(name = "TrabajoPracticoits.findByMateriaIts", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.materiaIts = :materiaIts")
    , @NamedQuery(name = "TrabajoPracticoits.findByAlumno", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.alumno = :alumno")
    , @NamedQuery(name = "TrabajoPracticoits.findBySemHabiNum", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.semHabiNum = :semHabiNum")
    , @NamedQuery(name = "TrabajoPracticoits.findBySemHabiAnho", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.semHabiAnho = :semHabiAnho")
    , @NamedQuery(name = "TrabajoPracticoits.findByGrupo", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.grupo = :grupo")
    , @NamedQuery(name = "TrabajoPracticoits.findByCarrera", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.carrera = :carrera")
    , @NamedQuery(name = "TrabajoPracticoits.findBySemestre", query = "SELECT t FROM TrabajoPracticoits t WHERE t.trabajoPracticoitsPK.semestre = :semestre")})
public class TrabajoPracticoits implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabajoPracticoitsPK trabajoPracticoitsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "puntajetotal")
    private Integer puntajetotal;
    @JoinColumns({
        @JoinColumn(name = "instructor", referencedColumnName = "instructor", insertable = false, updatable = false)
        , @JoinColumn(name = "materia_its", referencedColumnName = "materia_its", insertable = false, updatable = false)})
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

    public TrabajoPracticoits() {
        this.contratoInstructorits = new ContratoInstructorits();
        this.inscripcionIts = new InscripcionIts();
        this.trabajoPracticoitsPK = new TrabajoPracticoitsPK();
    }

    public TrabajoPracticoits(TrabajoPracticoitsPK trabajoPracticoitsPK) {
        this.trabajoPracticoitsPK = trabajoPracticoitsPK;
    }

    public TrabajoPracticoits(TrabajoPracticoitsPK trabajoPracticoitsPK, String nombre) {
        this.trabajoPracticoitsPK = trabajoPracticoitsPK;
        this.nombre = nombre;
    }

    public TrabajoPracticoits(int instructor, int materiaIts, int alumno, int semHabiNum, int semHabiAnho, int grupo, int carrera, int semestre) {
        this.trabajoPracticoitsPK = new TrabajoPracticoitsPK(instructor, materiaIts, alumno, semHabiNum, semHabiAnho, grupo, carrera, semestre);
    }

    public TrabajoPracticoitsPK getTrabajoPracticoitsPK() {
        return trabajoPracticoitsPK;
    }

    public void setTrabajoPracticoitsPK(TrabajoPracticoitsPK trabajoPracticoitsPK) {
        this.trabajoPracticoitsPK = trabajoPracticoitsPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Integer getPuntajetotal() {
        return puntajetotal;
    }

    public void setPuntajetotal(Integer puntajetotal) {
        this.puntajetotal = puntajetotal;
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
        hash += (trabajoPracticoitsPK != null ? trabajoPracticoitsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajoPracticoits)) {
            return false;
        }
        TrabajoPracticoits other = (TrabajoPracticoits) object;
        if ((this.trabajoPracticoitsPK == null && other.trabajoPracticoitsPK != null) || (this.trabajoPracticoitsPK != null && !this.trabajoPracticoitsPK.equals(other.trabajoPracticoitsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TrabajoPracticoits[ trabajoPracticoitsPK=" + trabajoPracticoitsPK + " ]";
    }
    
}
