/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "cpi")
@NamedQueries({
    @NamedQuery(name = "Cpi.findAll", query = "SELECT c FROM Cpi c")
    , @NamedQuery(name = "Cpi.findByNumeroNacional", query = "SELECT c FROM Cpi c WHERE c.numeroNacional = :numeroNacional")
    , @NamedQuery(name = "Cpi.findByCoordinadorIts", query = "SELECT c FROM Cpi c WHERE c.coordinadorIts = :coordinadorIts")
    , @NamedQuery(name = "Cpi.findByAnho", query = "SELECT c FROM Cpi c WHERE c.anho = :anho")
    , @NamedQuery(name = "Cpi.findByMunicipio", query = "SELECT c FROM Cpi c WHERE c.municipio = :municipio")
    , @NamedQuery(name = "Cpi.findByInicio", query = "SELECT c FROM Cpi c WHERE c.inicio = :inicio")
    , @NamedQuery(name = "Cpi.findByClausura", query = "SELECT c FROM Cpi c WHERE c.clausura = :clausura")
    , @NamedQuery(name = "Cpi.findByHorasTotales", query = "SELECT c FROM Cpi c WHERE c.horasTotales = :horasTotales")
    , @NamedQuery(name = "Cpi.findByFrecuencia", query = "SELECT c FROM Cpi c WHERE c.frecuencia = :frecuencia")
    , @NamedQuery(name = "Cpi.findByActivo", query = "SELECT c FROM Cpi c WHERE c.activo = :activo")})
public class Cpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_nacional")
    private String numeroNacional;
    @Size(max = 50)
    @Column(name = "coordinador_its")
    private String coordinadorIts;
    @Column(name = "anho")
    private Integer anho;
    @Size(max = 50)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 50)
    @Column(name = "inicio")
    private String inicio;
    @Size(max = 50)
    @Column(name = "clausura")
    private String clausura;
    @Size(max = 50)
    @Column(name = "horas_totales")
    private String horasTotales;
    @Size(max = 50)
    @Column(name = "frecuencia")
    private String frecuencia;
    @Column(name = "activo")
    private Boolean activo;
    @JoinTable(name = "carreras_cpi", joinColumns = {
        @JoinColumn(name = "cpi_numero_nacional", referencedColumnName = "numero_nacional")}, inverseJoinColumns = {
        @JoinColumn(name = "carrera", referencedColumnName = "id")})
    @ManyToMany
    private List<Carrera> carreraList;

    public Cpi() {
    }

    public Cpi(String numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public String getNumeroNacional() {
        return numeroNacional;
    }

    public void setNumeroNacional(String numeroNacional) {
        this.numeroNacional = numeroNacional;
    }

    public String getCoordinadorIts() {
        return coordinadorIts;
    }

    public void setCoordinadorIts(String coordinadorIts) {
        this.coordinadorIts = coordinadorIts;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getClausura() {
        return clausura;
    }

    public void setClausura(String clausura) {
        this.clausura = clausura;
    }

    public String getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(String horasTotales) {
        this.horasTotales = horasTotales;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
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
        if (!(object instanceof Cpi)) {
            return false;
        }
        Cpi other = (Cpi) object;
        if ((this.numeroNacional == null && other.numeroNacional != null) || (this.numeroNacional != null && !this.numeroNacional.equals(other.numeroNacional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cpi[ numeroNacional=" + numeroNacional + " ]";
    }
    
}
