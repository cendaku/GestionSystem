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
@Table(name = "horario_instructorits")
@NamedQueries({
    @NamedQuery(name = "HorarioInstructorits.findAll", query = "SELECT h FROM HorarioInstructorits h")
    , @NamedQuery(name = "HorarioInstructorits.findByHorario", query = "SELECT h FROM HorarioInstructorits h WHERE h.horarioInstructoritsPK.horario = :horario")
    , @NamedQuery(name = "HorarioInstructorits.findByNumeroHora", query = "SELECT h FROM HorarioInstructorits h WHERE h.numeroHora = :numeroHora")
    , @NamedQuery(name = "HorarioInstructorits.findByInstructor", query = "SELECT h FROM HorarioInstructorits h WHERE h.horarioInstructoritsPK.instructor = :instructor")
    , @NamedQuery(name = "HorarioInstructorits.findByMateriaIts", query = "SELECT h FROM HorarioInstructorits h WHERE h.horarioInstructoritsPK.materiaIts = :materiaIts")})
public class HorarioInstructorits implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioInstructoritsPK horarioInstructoritsPK;
    @Column(name = "numero_hora")
    private Integer numeroHora;
    @JoinColumn(name = "horario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horario horario1;
    @JoinColumns({
        @JoinColumn(name = "instructor", referencedColumnName = "instructor", insertable = false, updatable = false)
        , @JoinColumn(name = "materia_its", referencedColumnName = "materia_its", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ContratoInstructorits contratoInstructorits;

    public HorarioInstructorits() {
        this.contratoInstructorits = new ContratoInstructorits();
        this.horario1 = new Horario();
        this.horarioInstructoritsPK = new HorarioInstructoritsPK();
    }

    public HorarioInstructorits(HorarioInstructoritsPK horarioInstructoritsPK) {
        this.horarioInstructoritsPK = horarioInstructoritsPK;
    }

    public HorarioInstructorits(int horario, int instructor, int materiaIts) {
        this.horarioInstructoritsPK = new HorarioInstructoritsPK(horario, instructor, materiaIts);
    }

    public HorarioInstructoritsPK getHorarioInstructoritsPK() {
        return horarioInstructoritsPK;
    }

    public void setHorarioInstructoritsPK(HorarioInstructoritsPK horarioInstructoritsPK) {
        this.horarioInstructoritsPK = horarioInstructoritsPK;
    }

    public Integer getNumeroHora() {
        return numeroHora;
    }

    public void setNumeroHora(Integer numeroHora) {
        this.numeroHora = numeroHora;
    }

    public Horario getHorario1() {
        return horario1;
    }

    public void setHorario1(Horario horario1) {
        this.horario1 = horario1;
    }

    public ContratoInstructorits getContratoInstructorits() {
        return contratoInstructorits;
    }

    public void setContratoInstructorits(ContratoInstructorits contratoInstructorits) {
        this.contratoInstructorits = contratoInstructorits;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioInstructoritsPK != null ? horarioInstructoritsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioInstructorits)) {
            return false;
        }
        HorarioInstructorits other = (HorarioInstructorits) object;
        if ((this.horarioInstructoritsPK == null && other.horarioInstructoritsPK != null) || (this.horarioInstructoritsPK != null && !this.horarioInstructoritsPK.equals(other.horarioInstructoritsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorarioInstructorits[ horarioInstructoritsPK=" + horarioInstructoritsPK + " ]";
    }
    
}
