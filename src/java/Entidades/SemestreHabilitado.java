/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "semestre_habilitado")
@NamedQueries({
    @NamedQuery(name = "SemestreHabilitado.findAll", query = "SELECT s FROM SemestreHabilitado s")
    , @NamedQuery(name = "SemestreHabilitado.findById", query = "SELECT s FROM SemestreHabilitado s WHERE s.id = :id")
    , @NamedQuery(name = "SemestreHabilitado.findByNumeroNacional", query = "SELECT s FROM SemestreHabilitado s WHERE s.numeroNacional = :numeroNacional")
    , @NamedQuery(name = "SemestreHabilitado.findByAnho", query = "SELECT s FROM SemestreHabilitado s WHERE s.anho = :anho")
    , @NamedQuery(name = "SemestreHabilitado.findByMateriasTotalHoras", query = "SELECT s FROM SemestreHabilitado s WHERE s.materiasTotalHoras = :materiasTotalHoras")})
public class SemestreHabilitado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_nacional")
    private Integer numeroNacional;
    @Column(name = "anho")
    private Integer anho;
    @Column(name = "materias_total_horas")
    private Integer materiasTotalHoras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestreHabilitado")
    private List<HorarioIts> horarioItsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestreHabilitado")
    private List<MateriaIts> materiaItsList;
    @JoinColumn(name = "carrera_habilitada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CarreraHabilitada carreraHabilitada;
    @JoinColumn(name = "semestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semestre semestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestreHabilitado")
    private List<InscripcionIts> inscripcionItsList;

    public SemestreHabilitado() {
    }

    public SemestreHabilitado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroNacional() {
        return numeroNacional;
    }

    public void setNumeroNacional(Integer numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Integer getMateriasTotalHoras() {
        return materiasTotalHoras;
    }

    public void setMateriasTotalHoras(Integer materiasTotalHoras) {
        this.materiasTotalHoras = materiasTotalHoras;
    }

    public List<HorarioIts> getHorarioItsList() {
        return horarioItsList;
    }

    public void setHorarioItsList(List<HorarioIts> horarioItsList) {
        this.horarioItsList = horarioItsList;
    }

    public List<MateriaIts> getMateriaItsList() {
        return materiaItsList;
    }

    public void setMateriaItsList(List<MateriaIts> materiaItsList) {
        this.materiaItsList = materiaItsList;
    }

    public CarreraHabilitada getCarreraHabilitada() {
        return carreraHabilitada;
    }

    public void setCarreraHabilitada(CarreraHabilitada carreraHabilitada) {
        this.carreraHabilitada = carreraHabilitada;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<InscripcionIts> getInscripcionItsList() {
        return inscripcionItsList;
    }

    public void setInscripcionItsList(List<InscripcionIts> inscripcionItsList) {
        this.inscripcionItsList = inscripcionItsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemestreHabilitado)) {
            return false;
        }
        SemestreHabilitado other = (SemestreHabilitado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SemestreHabilitado[ id=" + id + " ]";
    }
    
}
