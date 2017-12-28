/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "puntaje_cpi")
@NamedQueries({
    @NamedQuery(name = "PuntajeCpi.findAll", query = "SELECT p FROM PuntajeCpi p")
    , @NamedQuery(name = "PuntajeCpi.findByInstructor", query = "SELECT p FROM PuntajeCpi p WHERE p.puntajeCpiPK.instructor = :instructor")
    , @NamedQuery(name = "PuntajeCpi.findByMateria", query = "SELECT p FROM PuntajeCpi p WHERE p.puntajeCpiPK.materia = :materia")
    , @NamedQuery(name = "PuntajeCpi.findByAlumno", query = "SELECT p FROM PuntajeCpi p WHERE p.puntajeCpiPK.alumno = :alumno")
    , @NamedQuery(name = "PuntajeCpi.findByCpiAnho", query = "SELECT p FROM PuntajeCpi p WHERE p.puntajeCpiPK.cpiAnho = :cpiAnho")
    , @NamedQuery(name = "PuntajeCpi.findByCpiNum", query = "SELECT p FROM PuntajeCpi p WHERE p.puntajeCpiPK.cpiNum = :cpiNum")
    , @NamedQuery(name = "PuntajeCpi.findByPuntosAlcanzados", query = "SELECT p FROM PuntajeCpi p WHERE p.puntosAlcanzados = :puntosAlcanzados")})
public class PuntajeCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuntajeCpiPK puntajeCpiPK;
    @Column(name = "puntos_alcanzados")
    private Integer puntosAlcanzados;
    @JoinColumn(name = "alumno", referencedColumnName = "alumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private InscripcionCpi inscripcionCpi;
    @JoinColumns({
        @JoinColumn(name = "instructor", referencedColumnName = "instructor", insertable = false, updatable = false)
        , @JoinColumn(name = "materia", referencedColumnName = "materia", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ContratoInstructorcpi contratoInstructorcpi;

    public PuntajeCpi() {
    }

    public PuntajeCpi(PuntajeCpiPK puntajeCpiPK) {
        this.puntajeCpiPK = puntajeCpiPK;
    }

    public PuntajeCpi(int instructor, int materia, int alumno, int cpiAnho, int cpiNum) {
        this.puntajeCpiPK = new PuntajeCpiPK(instructor, materia, alumno, cpiAnho, cpiNum);
    }

    public PuntajeCpiPK getPuntajeCpiPK() {
        return puntajeCpiPK;
    }

    public void setPuntajeCpiPK(PuntajeCpiPK puntajeCpiPK) {
        this.puntajeCpiPK = puntajeCpiPK;
    }

    public Integer getPuntosAlcanzados() {
        return puntosAlcanzados;
    }

    public void setPuntosAlcanzados(Integer puntosAlcanzados) {
        this.puntosAlcanzados = puntosAlcanzados;
    }

    public InscripcionCpi getInscripcionCpi() {
        return inscripcionCpi;
    }

    public void setInscripcionCpi(InscripcionCpi inscripcionCpi) {
        this.inscripcionCpi = inscripcionCpi;
    }

    public ContratoInstructorcpi getContratoInstructorcpi() {
        return contratoInstructorcpi;
    }

    public void setContratoInstructorcpi(ContratoInstructorcpi contratoInstructorcpi) {
        this.contratoInstructorcpi = contratoInstructorcpi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puntajeCpiPK != null ? puntajeCpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntajeCpi)) {
            return false;
        }
        PuntajeCpi other = (PuntajeCpi) object;
        if ((this.puntajeCpiPK == null && other.puntajeCpiPK != null) || (this.puntajeCpiPK != null && !this.puntajeCpiPK.equals(other.puntajeCpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PuntajeCpi[ puntajeCpiPK=" + puntajeCpiPK + " ]";
    }
    
}
