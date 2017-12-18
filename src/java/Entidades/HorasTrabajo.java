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
@Table(name = "horas_trabajo")
@NamedQueries({
    @NamedQuery(name = "HorasTrabajo.findAll", query = "SELECT h FROM HorasTrabajo h")
    , @NamedQuery(name = "HorasTrabajo.findById", query = "SELECT h FROM HorasTrabajo h WHERE h.id = :id")
    , @NamedQuery(name = "HorasTrabajo.findByDescripcion", query = "SELECT h FROM HorasTrabajo h WHERE h.descripcion = :descripcion")})
public class HorasTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horasTrabajo")
    private List<SituacionLaboral> situacionLaboralList;

    public HorasTrabajo() {
    }

    public HorasTrabajo(Integer id) {
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

    public List<SituacionLaboral> getSituacionLaboralList() {
        return situacionLaboralList;
    }

    public void setSituacionLaboralList(List<SituacionLaboral> situacionLaboralList) {
        this.situacionLaboralList = situacionLaboralList;
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
        if (!(object instanceof HorasTrabajo)) {
            return false;
        }
        HorasTrabajo other = (HorasTrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorasTrabajo[ id=" + id + " ]";
    }
    
}
