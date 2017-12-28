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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "inscripcion_cpi")
@NamedQueries({
    @NamedQuery(name = "InscripcionCpi.findAll", query = "SELECT i FROM InscripcionCpi i")
    , @NamedQuery(name = "InscripcionCpi.findByAlumno", query = "SELECT i FROM InscripcionCpi i WHERE i.alumno = :alumno")
    , @NamedQuery(name = "InscripcionCpi.findByPuntajeTotal", query = "SELECT i FROM InscripcionCpi i WHERE i.puntajeTotal = :puntajeTotal")
    , @NamedQuery(name = "InscripcionCpi.findByIngreso", query = "SELECT i FROM InscripcionCpi i WHERE i.ingreso = :ingreso")})
public class InscripcionCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alumno")
    private Integer alumno;
    @Column(name = "puntaje_total")
    private Integer puntajeTotal;
    @Column(name = "ingreso")
    private Boolean ingreso;
    @JoinColumn(name = "alternativa1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera alternativa1;
    @JoinColumn(name = "alternativa2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera alternativa2;
    @JoinColumn(name = "alumno", referencedColumnName = "ci", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Alumno alumno1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionCpi")
    private List<PuntajeCpi> puntajeCpiList;

    public InscripcionCpi() {
    }

    public InscripcionCpi(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public Carrera getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(Carrera alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public Carrera getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(Carrera alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
    }

    public List<PuntajeCpi> getPuntajeCpiList() {
        return puntajeCpiList;
    }

    public void setPuntajeCpiList(List<PuntajeCpi> puntajeCpiList) {
        this.puntajeCpiList = puntajeCpiList;
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
        if (!(object instanceof InscripcionCpi)) {
            return false;
        }
        InscripcionCpi other = (InscripcionCpi) object;
        if ((this.alumno == null && other.alumno != null) || (this.alumno != null && !this.alumno.equals(other.alumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionCpi[ alumno=" + alumno + " ]";
    }
    
}
