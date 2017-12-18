/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "inscripcion_cpi")
@NamedQueries({
    @NamedQuery(name = "InscripcionCpi.findAll", query = "SELECT i FROM InscripcionCpi i")
    , @NamedQuery(name = "InscripcionCpi.findByAlumno", query = "SELECT i FROM InscripcionCpi i WHERE i.inscripcionCpiPK.alumno = :alumno")
    , @NamedQuery(name = "InscripcionCpi.findByPuntajeTotal", query = "SELECT i FROM InscripcionCpi i WHERE i.puntajeTotal = :puntajeTotal")
    , @NamedQuery(name = "InscripcionCpi.findByCpiAnho", query = "SELECT i FROM InscripcionCpi i WHERE i.inscripcionCpiPK.cpiAnho = :cpiAnho")
    , @NamedQuery(name = "InscripcionCpi.findByCpiNum", query = "SELECT i FROM InscripcionCpi i WHERE i.inscripcionCpiPK.cpiNum = :cpiNum")
    , @NamedQuery(name = "InscripcionCpi.findByIngreso", query = "SELECT i FROM InscripcionCpi i WHERE i.ingreso = :ingreso")})
public class InscripcionCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionCpiPK inscripcionCpiPK;
    @Column(name = "puntaje_total")
    private Integer puntajeTotal;
    @Column(name = "ingreso")
    private Boolean ingreso;
    @JoinColumns({
        @JoinColumn(name = "cpi_anho", referencedColumnName = "anho", insertable = false, updatable = false)
        , @JoinColumn(name = "cpi_num", referencedColumnName = "numero_nacional", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PdCpi pdCpi;
    @JoinColumn(name = "alumno", referencedColumnName = "ci", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno1;
    @JoinColumn(name = "alternativa1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera alternativa1;
    @JoinColumn(name = "alternativa2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera alternativa2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionCpi")
    private List<PuntajeCpi> puntajeCpiList;

    public InscripcionCpi() {
        this.alternativa1 = new Carrera();
        this.alternativa2 = new Carrera();
        this.alumno1 = new Alumno();
        this.pdCpi = new PdCpi();
    }

    public InscripcionCpi(InscripcionCpiPK inscripcionCpiPK) {
        this.inscripcionCpiPK = inscripcionCpiPK;
    }

    public InscripcionCpi(int alumno, int cpiAnho, int cpiNum) {
        this.inscripcionCpiPK = new InscripcionCpiPK(alumno, cpiAnho, cpiNum);
    }

    public InscripcionCpiPK getInscripcionCpiPK() {
        return inscripcionCpiPK;
    }

    public void setInscripcionCpiPK(InscripcionCpiPK inscripcionCpiPK) {
        this.inscripcionCpiPK = inscripcionCpiPK;
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

    public PdCpi getPdCpi() {
        return pdCpi;
    }

    public void setPdCpi(PdCpi pdCpi) {
        this.pdCpi = pdCpi;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
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

    public List<PuntajeCpi> getPuntajeCpiList() {
        return puntajeCpiList;
    }

    public void setPuntajeCpiList(List<PuntajeCpi> puntajeCpiList) {
        this.puntajeCpiList = puntajeCpiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionCpiPK != null ? inscripcionCpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionCpi)) {
            return false;
        }
        InscripcionCpi other = (InscripcionCpi) object;
        if ((this.inscripcionCpiPK == null && other.inscripcionCpiPK != null) || (this.inscripcionCpiPK != null && !this.inscripcionCpiPK.equals(other.inscripcionCpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InscripcionCpi[ inscripcionCpiPK=" + inscripcionCpiPK + " ]";
    }
    
}
