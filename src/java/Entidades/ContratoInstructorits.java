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
@Table(name = "contrato_instructorits")
@NamedQueries({
    @NamedQuery(name = "ContratoInstructorits.findAll", query = "SELECT c FROM ContratoInstructorits c")
    , @NamedQuery(name = "ContratoInstructorits.findByInstructor", query = "SELECT c FROM ContratoInstructorits c WHERE c.contratoInstructoritsPK.instructor = :instructor")
    , @NamedQuery(name = "ContratoInstructorits.findByMateriaIts", query = "SELECT c FROM ContratoInstructorits c WHERE c.contratoInstructoritsPK.materiaIts = :materiaIts")
    , @NamedQuery(name = "ContratoInstructorits.findByPd", query = "SELECT c FROM ContratoInstructorits c WHERE c.pd = :pd")})
public class ContratoInstructorits implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoInstructoritsPK contratoInstructoritsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PD")
    private int pd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorits1")
    private List<AsistenciaIts> asistenciaItsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorits")
    private List<TrabajoPracticoits> trabajoPracticoitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorits")
    private List<Notasits> notasitsList;
    @JoinColumn(name = "materia_its", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MateriaIts materiaIts1;
    @JoinColumn(name = "instructor", referencedColumnName = "ci", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instructor instructor1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorits")
    private List<HorarioInstructorits> horarioInstructoritsList;

    public ContratoInstructorits() {
        this.contratoInstructoritsPK = new ContratoInstructoritsPK();
        this.instructor1 = new Instructor();
        this.materiaIts1 = new MateriaIts();
    }

    public ContratoInstructorits(ContratoInstructoritsPK contratoInstructoritsPK) {
        this.contratoInstructoritsPK = contratoInstructoritsPK;
    }

    public ContratoInstructorits(ContratoInstructoritsPK contratoInstructoritsPK, int pd) {
        this.contratoInstructoritsPK = contratoInstructoritsPK;
        this.pd = pd;
    }

    public ContratoInstructorits(int instructor, int materiaIts) {
        this.contratoInstructoritsPK = new ContratoInstructoritsPK(instructor, materiaIts);
    }

    public ContratoInstructoritsPK getContratoInstructoritsPK() {
        return contratoInstructoritsPK;
    }

    public void setContratoInstructoritsPK(ContratoInstructoritsPK contratoInstructoritsPK) {
        this.contratoInstructoritsPK = contratoInstructoritsPK;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public List<AsistenciaIts> getAsistenciaItsList() {
        return asistenciaItsList;
    }

    public void setAsistenciaItsList(List<AsistenciaIts> asistenciaItsList) {
        this.asistenciaItsList = asistenciaItsList;
    }

    public List<TrabajoPracticoits> getTrabajoPracticoitsList() {
        return trabajoPracticoitsList;
    }

    public void setTrabajoPracticoitsList(List<TrabajoPracticoits> trabajoPracticoitsList) {
        this.trabajoPracticoitsList = trabajoPracticoitsList;
    }

    public List<Notasits> getNotasitsList() {
        return notasitsList;
    }

    public void setNotasitsList(List<Notasits> notasitsList) {
        this.notasitsList = notasitsList;
    }

    public MateriaIts getMateriaIts1() {
        return materiaIts1;
    }

    public void setMateriaIts1(MateriaIts materiaIts1) {
        this.materiaIts1 = materiaIts1;
    }

    public Instructor getInstructor1() {
        return instructor1;
    }

    public void setInstructor1(Instructor instructor1) {
        this.instructor1 = instructor1;
    }

    public List<HorarioInstructorits> getHorarioInstructoritsList() {
        return horarioInstructoritsList;
    }

    public void setHorarioInstructoritsList(List<HorarioInstructorits> horarioInstructoritsList) {
        this.horarioInstructoritsList = horarioInstructoritsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratoInstructoritsPK != null ? contratoInstructoritsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoInstructorits)) {
            return false;
        }
        ContratoInstructorits other = (ContratoInstructorits) object;
        if ((this.contratoInstructoritsPK == null && other.contratoInstructoritsPK != null) || (this.contratoInstructoritsPK != null && !this.contratoInstructoritsPK.equals(other.contratoInstructoritsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoInstructorits[ contratoInstructoritsPK=" + contratoInstructoritsPK + " ]";
    }
    
}
