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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "inscripcion_its")
@NamedQueries({
    @NamedQuery(name = "InscripcionIts.findAll", query = "SELECT i FROM InscripcionIts i")
    , @NamedQuery(name = "InscripcionIts.findById", query = "SELECT i FROM InscripcionIts i WHERE i.id = :id")})
public class InscripcionIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionItsId")
    private List<AsistenciaIts> asistenciaItsList;
    @JoinColumn(name = "alumno", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "semestre_habilitado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SemestreHabilitado semestreHabilitado;

    public InscripcionIts() {
    }

    public InscripcionIts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AsistenciaIts> getAsistenciaItsList() {
        return asistenciaItsList;
    }

    public void setAsistenciaItsList(List<AsistenciaIts> asistenciaItsList) {
        this.asistenciaItsList = asistenciaItsList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public SemestreHabilitado getSemestreHabilitado() {
        return semestreHabilitado;
    }

    public void setSemestreHabilitado(SemestreHabilitado semestreHabilitado) {
        this.semestreHabilitado = semestreHabilitado;
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
        if (!(object instanceof InscripcionIts)) {
            return false;
        }
        InscripcionIts other = (InscripcionIts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionIts[ id=" + id + " ]";
    }
    
}
