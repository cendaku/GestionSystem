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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    , @NamedQuery(name = "HorarioInstructorits.findById", query = "SELECT h FROM HorarioInstructorits h WHERE h.id = :id")
    , @NamedQuery(name = "HorarioInstructorits.findByNumeroHora", query = "SELECT h FROM HorarioInstructorits h WHERE h.numeroHora = :numeroHora")})
public class HorarioInstructorits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_hora")
    private Integer numeroHora;
    @JoinColumn(name = "horario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "instructor", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "materia_its", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MateriaIts materiaIts;

    public HorarioInstructorits() {
    }

    public HorarioInstructorits(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroHora() {
        return numeroHora;
    }

    public void setNumeroHora(Integer numeroHora) {
        this.numeroHora = numeroHora;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public MateriaIts getMateriaIts() {
        return materiaIts;
    }

    public void setMateriaIts(MateriaIts materiaIts) {
        this.materiaIts = materiaIts;
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
        if (!(object instanceof HorarioInstructorits)) {
            return false;
        }
        HorarioInstructorits other = (HorarioInstructorits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorarioInstructorits[ id=" + id + " ]";
    }
    
}
