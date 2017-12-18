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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "discapacidad")
@NamedQueries({
    @NamedQuery(name = "Discapacidad.findAll", query = "SELECT d FROM Discapacidad d")
    , @NamedQuery(name = "Discapacidad.findById", query = "SELECT d FROM Discapacidad d WHERE d.id = :id")
    , @NamedQuery(name = "Discapacidad.findByDescripcion", query = "SELECT d FROM Discapacidad d WHERE d.descripcion = :descripcion")})
public class Discapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "detalle_discapacidad", joinColumns = {
        @JoinColumn(name = "discapacidad", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "alumno", referencedColumnName = "ci")})
    @ManyToMany
    private List<Alumno> alumnoList;

    public Discapacidad() {
        this.id=0;
    }

    public Discapacidad(Integer id) {
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

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
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
        if (!(object instanceof Discapacidad)) {
            return false;
        }
        Discapacidad other = (Discapacidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Discapacidad[ id=" + id + " ]";
    }
    
}
