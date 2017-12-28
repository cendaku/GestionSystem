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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
    , @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id")
    , @NamedQuery(name = "Grupo.findByResolucion", query = "SELECT g FROM Grupo g WHERE g.resolucion = :resolucion")
    , @NamedQuery(name = "Grupo.findByAnhoInicial", query = "SELECT g FROM Grupo g WHERE g.anhoInicial = :anhoInicial")
    , @NamedQuery(name = "Grupo.findByAnhoFinal", query = "SELECT g FROM Grupo g WHERE g.anhoFinal = :anhoFinal")
    , @NamedQuery(name = "Grupo.findByActivo", query = "SELECT g FROM Grupo g WHERE g.activo = :activo")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "resolucion")
    private String resolucion;
    @Size(max = 6)
    @Column(name = "anho_inicial")
    private String anhoInicial;
    @Size(max = 6)
    @Column(name = "anho_final")
    private String anhoFinal;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo1")
    private List<CarreraHabilitada> carreraHabilitadaList;

    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getAnhoInicial() {
        return anhoInicial;
    }

    public void setAnhoInicial(String anhoInicial) {
        this.anhoInicial = anhoInicial;
    }

    public String getAnhoFinal() {
        return anhoFinal;
    }

    public void setAnhoFinal(String anhoFinal) {
        this.anhoFinal = anhoFinal;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<CarreraHabilitada> getCarreraHabilitadaList() {
        return carreraHabilitadaList;
    }

    public void setCarreraHabilitadaList(List<CarreraHabilitada> carreraHabilitadaList) {
        this.carreraHabilitadaList = carreraHabilitadaList;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Grupo[ id=" + id + " ]";
    }
    
}
