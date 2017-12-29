/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByNumeroNacional", query = "SELECT c FROM Curso c WHERE c.numeroNacional = :numeroNacional")
    , @NamedQuery(name = "Curso.findByNumeroRegional", query = "SELECT c FROM Curso c WHERE c.numeroRegional = :numeroRegional")
    , @NamedQuery(name = "Curso.findByHoraEntrada", query = "SELECT c FROM Curso c WHERE c.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Curso.findByHoraSalida", query = "SELECT c FROM Curso c WHERE c.horaSalida = :horaSalida")
    , @NamedQuery(name = "Curso.findByFechaInicio", query = "SELECT c FROM Curso c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Curso.findByFechaClausura", query = "SELECT c FROM Curso c WHERE c.fechaClausura = :fechaClausura")
    , @NamedQuery(name = "Curso.findByActivo", query = "SELECT c FROM Curso c WHERE c.activo = :activo")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_nacional")
    private Integer numeroNacional;
    @Size(max = 50)
    @Column(name = "numero_regional")
    private String numeroRegional;
    @Size(max = 50)
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Size(max = 50)
    @Column(name = "hora_salida")
    private String horaSalida;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_clausura")
    @Temporal(TemporalType.DATE)
    private Date fechaClausura;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso1")
    private List<InscripcionFpa> inscripcionFpaList;
    @JoinColumn(name = "especialidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Especialidad especialidad;
    @JoinColumn(name = "frecuencia_diaria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FrecuenciaDiaria frecuenciaDiaria;
    @JoinColumn(name = "instructor", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "localidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Localidad localidad;
    @JoinColumn(name = "tipo_frecuencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoFrecuencia tipoFrecuencia;

    public Curso() {
    }

    public Curso(Integer numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public Integer getNumeroNacional() {
        return numeroNacional;
    }

    public void setNumeroNacional(Integer numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public String getNumeroRegional() {
        return numeroRegional;
    }

    public void setNumeroRegional(String numeroRegional) {
        this.numeroRegional = numeroRegional;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaClausura() {
        return fechaClausura;
    }

    public void setFechaClausura(Date fechaClausura) {
        this.fechaClausura = fechaClausura;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<InscripcionFpa> getInscripcionFpaList() {
        return inscripcionFpaList;
    }

    public void setInscripcionFpaList(List<InscripcionFpa> inscripcionFpaList) {
        this.inscripcionFpaList = inscripcionFpaList;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public FrecuenciaDiaria getFrecuenciaDiaria() {
        return frecuenciaDiaria;
    }

    public void setFrecuenciaDiaria(FrecuenciaDiaria frecuenciaDiaria) {
        this.frecuenciaDiaria = frecuenciaDiaria;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public TipoFrecuencia getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setTipoFrecuencia(TipoFrecuencia tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroNacional != null ? numeroNacional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.numeroNacional == null && other.numeroNacional != null) || (this.numeroNacional != null && !this.numeroNacional.equals(other.numeroNacional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Curso[ numeroNacional=" + numeroNacional + " ]";
    }
    
}
