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
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "contrato_instructorits")
@NamedQueries({
    @NamedQuery(name = "ContratoInstructorits.findAll", query = "SELECT c FROM ContratoInstructorits c")
    , @NamedQuery(name = "ContratoInstructorits.findById", query = "SELECT c FROM ContratoInstructorits c WHERE c.id = :id")
    , @NamedQuery(name = "ContratoInstructorits.findByPd", query = "SELECT c FROM ContratoInstructorits c WHERE c.pd = :pd")})
public class ContratoInstructorits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PD")
    private int pd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoInstructorits")
    private List<Notasits> notasitsList;
    @JoinColumn(name = "instructor", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "materia_its", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MateriaIts materiaIts;

    public ContratoInstructorits() {
    }

    public ContratoInstructorits(Integer id) {
        this.id = id;
    }

    public ContratoInstructorits(Integer id, int pd) {
        this.id = id;
        this.pd = pd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public List<Notasits> getNotasitsList() {
        return notasitsList;
    }

    public void setNotasitsList(List<Notasits> notasitsList) {
        this.notasitsList = notasitsList;
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
        if (!(object instanceof ContratoInstructorits)) {
            return false;
        }
        ContratoInstructorits other = (ContratoInstructorits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoInstructorits[ id=" + id + " ]";
    }
    
}
