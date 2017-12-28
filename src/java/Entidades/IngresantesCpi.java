/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "ingresantes_cpi")
@NamedQueries({
    @NamedQuery(name = "IngresantesCpi.findAll", query = "SELECT i FROM IngresantesCpi i")
    , @NamedQuery(name = "IngresantesCpi.findByAlumno", query = "SELECT i FROM IngresantesCpi i WHERE i.alumno = :alumno")})
public class IngresantesCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private Integer alumno;
    @JoinColumn(name = "alumno", referencedColumnName = "ci", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Alumno alumno1;

    public IngresantesCpi() {
    }

    public IngresantesCpi(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumno != null ? alumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresantesCpi)) {
            return false;
        }
        IngresantesCpi other = (IngresantesCpi) object;
        if ((this.alumno == null && other.alumno != null) || (this.alumno != null && !this.alumno.equals(other.alumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.IngresantesCpi[ alumno=" + alumno + " ]";
    }
    
}
