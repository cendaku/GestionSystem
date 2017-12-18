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
@Table(name = "materia_cpi")
@NamedQueries({
    @NamedQuery(name = "MateriaCpi.findAll", query = "SELECT m FROM MateriaCpi m")
    , @NamedQuery(name = "MateriaCpi.findById", query = "SELECT m FROM MateriaCpi m WHERE m.id = :id")
    , @NamedQuery(name = "MateriaCpi.findByDescripcion", query = "SELECT m FROM MateriaCpi m WHERE m.descripcion = :descripcion")})
public class MateriaCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaCpi")
    private List<ContratoInstructorcpi> contratoInstructorcpiList;

    public MateriaCpi() {
        this.id=0;
    }

    public MateriaCpi(Integer id) {
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

    public List<ContratoInstructorcpi> getContratoInstructorcpiList() {
        return contratoInstructorcpiList;
    }

    public void setContratoInstructorcpiList(List<ContratoInstructorcpi> contratoInstructorcpiList) {
        this.contratoInstructorcpiList = contratoInstructorcpiList;
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
        if (!(object instanceof MateriaCpi)) {
            return false;
        }
        MateriaCpi other = (MateriaCpi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MateriaCpi[ id=" + id + " ]";
    }
    
}
