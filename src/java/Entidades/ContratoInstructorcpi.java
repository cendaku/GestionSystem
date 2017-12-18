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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "contrato_instructorcpi")
@NamedQueries({
    @NamedQuery(name = "ContratoInstructorcpi.findAll", query = "SELECT c FROM ContratoInstructorcpi c")
    , @NamedQuery(name = "ContratoInstructorcpi.findByInstructor", query = "SELECT c FROM ContratoInstructorcpi c WHERE c.contratoInstructorcpiPK.instructor = :instructor")
    , @NamedQuery(name = "ContratoInstructorcpi.findByMateria", query = "SELECT c FROM ContratoInstructorcpi c WHERE c.contratoInstructorcpiPK.materia = :materia")
    , @NamedQuery(name = "ContratoInstructorcpi.findByPd", query = "SELECT c FROM ContratoInstructorcpi c WHERE c.pd = :pd")})
public class ContratoInstructorcpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoInstructorcpiPK contratoInstructorcpiPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PD")
    private int pd;
    @JoinTable(name = "horario_instructorcpi", joinColumns = {
        @JoinColumn(name = "instructor", referencedColumnName = "instructor")
        , @JoinColumn(name = "materia", referencedColumnName = "materia")}, inverseJoinColumns = {
        @JoinColumn(name = "horario", referencedColumnName = "id")})
    @ManyToMany
    private List<Horario> horarioList;
    @JoinColumn(name = "instructor", referencedColumnName = "ci", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instructor instructor1;
    @JoinColumn(name = "materia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MateriaCpi materiaCpi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorcpi")
    private List<PuntajeCpi> puntajeCpiList;

    public ContratoInstructorcpi() {
        this.instructor1 = new Instructor();
        this.materiaCpi = new MateriaCpi();
    }

    public ContratoInstructorcpi(ContratoInstructorcpiPK contratoInstructorcpiPK) {
        this.contratoInstructorcpiPK = contratoInstructorcpiPK;
    }

    public ContratoInstructorcpi(ContratoInstructorcpiPK contratoInstructorcpiPK, int pd) {
        this.contratoInstructorcpiPK = contratoInstructorcpiPK;
        this.pd = pd;
    }

    public ContratoInstructorcpi(int instructor, int materia) {
        this.contratoInstructorcpiPK = new ContratoInstructorcpiPK(instructor, materia);
    }

    public ContratoInstructorcpiPK getContratoInstructorcpiPK() {
        return contratoInstructorcpiPK;
    }

    public void setContratoInstructorcpiPK(ContratoInstructorcpiPK contratoInstructorcpiPK) {
        this.contratoInstructorcpiPK = contratoInstructorcpiPK;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public Instructor getInstructor1() {
        return instructor1;
    }

    public void setInstructor1(Instructor instructor1) {
        this.instructor1 = instructor1;
    }

    public MateriaCpi getMateriaCpi() {
        return materiaCpi;
    }

    public void setMateriaCpi(MateriaCpi materiaCpi) {
        this.materiaCpi = materiaCpi;
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
        hash += (contratoInstructorcpiPK != null ? contratoInstructorcpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoInstructorcpi)) {
            return false;
        }
        ContratoInstructorcpi other = (ContratoInstructorcpi) object;
        if ((this.contratoInstructorcpiPK == null && other.contratoInstructorcpiPK != null) || (this.contratoInstructorcpiPK != null && !this.contratoInstructorcpiPK.equals(other.contratoInstructorcpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoInstructorcpi[ contratoInstructorcpiPK=" + contratoInstructorcpiPK + " ]";
    }
    
}
