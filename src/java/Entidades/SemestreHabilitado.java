/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
    , @NamedQuery(name = "SemestreHabilitado.findByNumeroNacional", query = "SELECT s FROM SemestreHabilitado s WHERE s.semestreHabilitadoPK.numeroNacional = :numeroNacional")
    , @NamedQuery(name = "SemestreHabilitado.findByAnho", query = "SELECT s FROM SemestreHabilitado s WHERE s.semestreHabilitadoPK.anho = :anho")
    , @NamedQuery(name = "SemestreHabilitado.findByGrupo", query = "SELECT s FROM SemestreHabilitado s WHERE s.semestreHabilitadoPK.grupo = :grupo")
    , @NamedQuery(name = "SemestreHabilitado.findByCarrera", query = "SELECT s FROM SemestreHabilitado s WHERE s.semestreHabilitadoPK.carrera = :carrera")
    , @NamedQuery(name = "SemestreHabilitado.findBySemestre", query = "SELECT s FROM SemestreHabilitado s WHERE s.semestreHabilitadoPK.semestre = :semestre")
    , @NamedQuery(name = "SemestreHabilitado.findByMateriasTotalHoras", query = "SELECT s FROM SemestreHabilitado s WHERE s.materiasTotalHoras = :materiasTotalHoras")})
public class SemestreHabilitado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SemestreHabilitadoPK semestreHabilitadoPK;
    @Column(name = "materias_total_horas")
    private Integer materiasTotalHoras;
    @ManyToMany(mappedBy = "semestreHabilitadoList")
    private List<Horario> horarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestreHabilitado")
    private List<MateriaIts> materiaItsList;
    @JoinColumns({
        @JoinColumn(name = "grupo", referencedColumnName = "grupo", insertable = false, updatable = false)
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CarreraHabilitada carreraHabilitada;
    @JoinColumn(name = "semestre", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Semestre semestre1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestreHabilitado")
    private List<InscripcionIts> inscripcionItsList;

    public SemestreHabilitado() {
    }

    public SemestreHabilitado(SemestreHabilitadoPK semestreHabilitadoPK) {
        this.semestreHabilitadoPK = semestreHabilitadoPK;
    }

    public SemestreHabilitado(int numeroNacional, int anho, int grupo, int carrera, int semestre) {
        this.semestreHabilitadoPK = new SemestreHabilitadoPK(numeroNacional, anho, grupo, carrera, semestre);
    }

    public SemestreHabilitadoPK getSemestreHabilitadoPK() {
        return semestreHabilitadoPK;
    }

    public void setSemestreHabilitadoPK(SemestreHabilitadoPK semestreHabilitadoPK) {
        this.semestreHabilitadoPK = semestreHabilitadoPK;
    }

    public Integer getMateriasTotalHoras() {
        return materiasTotalHoras;
    }

    public void setMateriasTotalHoras(Integer materiasTotalHoras) {
        this.materiasTotalHoras = materiasTotalHoras;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
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

    public Semestre getSemestre1() {
        return semestre1;
    }

    public void setSemestre1(Semestre semestre1) {
        this.semestre1 = semestre1;
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
        hash += (semestreHabilitadoPK != null ? semestreHabilitadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemestreHabilitado)) {
            return false;
        }
        SemestreHabilitado other = (SemestreHabilitado) object;
        if ((this.semestreHabilitadoPK == null && other.semestreHabilitadoPK != null) || (this.semestreHabilitadoPK != null && !this.semestreHabilitadoPK.equals(other.semestreHabilitadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SemestreHabilitado[ semestreHabilitadoPK=" + semestreHabilitadoPK + " ]";
    }
    
}
