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
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "carga_horariaits")
@NamedQueries({
    @NamedQuery(name = "CargaHorariaits.findAll", query = "SELECT c FROM CargaHorariaits c")
    , @NamedQuery(name = "CargaHorariaits.findById", query = "SELECT c FROM CargaHorariaits c WHERE c.id = :id")
    , @NamedQuery(name = "CargaHorariaits.findByPractica", query = "SELECT c FROM CargaHorariaits c WHERE c.practica = :practica")
    , @NamedQuery(name = "CargaHorariaits.findByTeoria", query = "SELECT c FROM CargaHorariaits c WHERE c.teoria = :teoria")
    , @NamedQuery(name = "CargaHorariaits.findByTotal", query = "SELECT c FROM CargaHorariaits c WHERE c.total = :total")})
public class CargaHorariaits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "practica")
    private int practica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teoria")
    private int teoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargahoraria")
    private List<MateriaIts> materiaItsList;

    public CargaHorariaits() {
    }

    public CargaHorariaits(Integer id) {
        this.id = id;
    }

    public CargaHorariaits(Integer id, int practica, int teoria, int total) {
        this.id = id;
        this.practica = practica;
        this.teoria = teoria;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPractica() {
        return practica;
    }

    public void setPractica(int practica) {
        this.practica = practica;
    }

    public int getTeoria() {
        return teoria;
    }

    public void setTeoria(int teoria) {
        this.teoria = teoria;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MateriaIts> getMateriaItsList() {
        return materiaItsList;
    }

    public void setMateriaItsList(List<MateriaIts> materiaItsList) {
        this.materiaItsList = materiaItsList;
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
        if (!(object instanceof CargaHorariaits)) {
            return false;
        }
        CargaHorariaits other = (CargaHorariaits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CargaHorariaits[ id=" + id + " ]";
    }
    
}
