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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "carrera")
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findById", query = "SELECT c FROM Carrera c WHERE c.id = :id")
    , @NamedQuery(name = "Carrera.findByDescripcion", query = "SELECT c FROM Carrera c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Carrera.findByHabilitada", query = "SELECT c FROM Carrera c WHERE c.habilitada = :habilitada")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "habilitada")
    private Boolean habilitada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alternativa1")
    private List<InscripcionCpi> inscripcionCpiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alternativa2")
    private List<InscripcionCpi> inscripcionCpiList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera1")
    private List<CarreraHabilitada> carreraHabilitadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera1")
    private List<CarrerasCpi> carrerasCpiList;

    public Carrera() {
    }

    public Carrera(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(Boolean habilitada) {
        this.habilitada = habilitada;
    }

    public List<InscripcionCpi> getInscripcionCpiList() {
        return inscripcionCpiList;
    }

    public void setInscripcionCpiList(List<InscripcionCpi> inscripcionCpiList) {
        this.inscripcionCpiList = inscripcionCpiList;
    }

    public List<InscripcionCpi> getInscripcionCpiList1() {
        return inscripcionCpiList1;
    }

    public void setInscripcionCpiList1(List<InscripcionCpi> inscripcionCpiList1) {
        this.inscripcionCpiList1 = inscripcionCpiList1;
    }

    public List<CarreraHabilitada> getCarreraHabilitadaList() {
        return carreraHabilitadaList;
    }

    public void setCarreraHabilitadaList(List<CarreraHabilitada> carreraHabilitadaList) {
        this.carreraHabilitadaList = carreraHabilitadaList;
    }

    public List<CarrerasCpi> getCarrerasCpiList() {
        return carrerasCpiList;
    }

    public void setCarrerasCpiList(List<CarrerasCpi> carrerasCpiList) {
        this.carrerasCpiList = carrerasCpiList;
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
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Carrera[ id=" + id + " ]";
    }
    
}
