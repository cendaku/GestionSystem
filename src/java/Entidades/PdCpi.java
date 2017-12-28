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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "pd_cpi")
@NamedQueries({
    @NamedQuery(name = "PdCpi.findAll", query = "SELECT p FROM PdCpi p")
    , @NamedQuery(name = "PdCpi.findByActivo", query = "SELECT p FROM PdCpi p WHERE p.activo = :activo")
    , @NamedQuery(name = "PdCpi.findByAreaDesarrollo", query = "SELECT p FROM PdCpi p WHERE p.areaDesarrollo = :areaDesarrollo")
    , @NamedQuery(name = "PdCpi.findByClausura", query = "SELECT p FROM PdCpi p WHERE p.clausura = :clausura")
    , @NamedQuery(name = "PdCpi.findByCoordinadorIts", query = "SELECT p FROM PdCpi p WHERE p.coordinadorIts = :coordinadorIts")
    , @NamedQuery(name = "PdCpi.findByEspecialidad", query = "SELECT p FROM PdCpi p WHERE p.especialidad = :especialidad")
    , @NamedQuery(name = "PdCpi.findByFrecuencia", query = "SELECT p FROM PdCpi p WHERE p.frecuencia = :frecuencia")
    , @NamedQuery(name = "PdCpi.findByHorasTotales", query = "SELECT p FROM PdCpi p WHERE p.horasTotales = :horasTotales")
    , @NamedQuery(name = "PdCpi.findByInicio", query = "SELECT p FROM PdCpi p WHERE p.inicio = :inicio")
    , @NamedQuery(name = "PdCpi.findByMunicipio", query = "SELECT p FROM PdCpi p WHERE p.municipio = :municipio")
    , @NamedQuery(name = "PdCpi.findByPrograma", query = "SELECT p FROM PdCpi p WHERE p.programa = :programa")
    , @NamedQuery(name = "PdCpi.findByUnidadOperativa", query = "SELECT p FROM PdCpi p WHERE p.unidadOperativa = :unidadOperativa")
    , @NamedQuery(name = "PdCpi.findByAnho", query = "SELECT p FROM PdCpi p WHERE p.pdCpiPK.anho = :anho")
    , @NamedQuery(name = "PdCpi.findByNumeroNacional", query = "SELECT p FROM PdCpi p WHERE p.pdCpiPK.numeroNacional = :numeroNacional")})
public class PdCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PdCpiPK pdCpiPK;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 255)
    @Column(name = "area_desarrollo")
    private String areaDesarrollo;
    @Size(max = 255)
    @Column(name = "clausura")
    private String clausura;
    @Size(max = 255)
    @Column(name = "coordinador_its")
    private String coordinadorIts;
    @Size(max = 255)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 255)
    @Column(name = "frecuencia")
    private String frecuencia;
    @Size(max = 255)
    @Column(name = "horas_totales")
    private String horasTotales;
    @Size(max = 255)
    @Column(name = "inicio")
    private String inicio;
    @Size(max = 255)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 255)
    @Column(name = "programa")
    private String programa;
    @Size(max = 255)
    @Column(name = "unidad_operativa")
    private String unidadOperativa;

    public PdCpi() {
    }

    public PdCpi(PdCpiPK pdCpiPK) {
        this.pdCpiPK = pdCpiPK;
    }

    public PdCpi(int anho, int numeroNacional) {
        this.pdCpiPK = new PdCpiPK(anho, numeroNacional);
    }

    public PdCpiPK getPdCpiPK() {
        return pdCpiPK;
    }

    public void setPdCpiPK(PdCpiPK pdCpiPK) {
        this.pdCpiPK = pdCpiPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getAreaDesarrollo() {
        return areaDesarrollo;
    }

    public void setAreaDesarrollo(String areaDesarrollo) {
        this.areaDesarrollo = areaDesarrollo;
    }

    public String getClausura() {
        return clausura;
    }

    public void setClausura(String clausura) {
        this.clausura = clausura;
    }

    public String getCoordinadorIts() {
        return coordinadorIts;
    }

    public void setCoordinadorIts(String coordinadorIts) {
        this.coordinadorIts = coordinadorIts;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(String horasTotales) {
        this.horasTotales = horasTotales;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getUnidadOperativa() {
        return unidadOperativa;
    }

    public void setUnidadOperativa(String unidadOperativa) {
        this.unidadOperativa = unidadOperativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdCpiPK != null ? pdCpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PdCpi)) {
            return false;
        }
        PdCpi other = (PdCpi) object;
        if ((this.pdCpiPK == null && other.pdCpiPK != null) || (this.pdCpiPK != null && !this.pdCpiPK.equals(other.pdCpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PdCpi[ pdCpiPK=" + pdCpiPK + " ]";
    }
    
}
