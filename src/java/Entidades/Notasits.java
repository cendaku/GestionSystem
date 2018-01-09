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
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "notasits")
@NamedQueries({
    @NamedQuery(name = "Notasits.findAll", query = "SELECT n FROM Notasits n")
    , @NamedQuery(name = "Notasits.findById", query = "SELECT n FROM Notasits n WHERE n.id = :id")
    , @NamedQuery(name = "Notasits.findByParcial1", query = "SELECT n FROM Notasits n WHERE n.parcial1 = :parcial1")
    , @NamedQuery(name = "Notasits.findByParcial2", query = "SELECT n FROM Notasits n WHERE n.parcial2 = :parcial2")
    , @NamedQuery(name = "Notasits.findByFinal1", query = "SELECT n FROM Notasits n WHERE n.final1 = :final1")
    , @NamedQuery(name = "Notasits.findByRecuperatorio", query = "SELECT n FROM Notasits n WHERE n.recuperatorio = :recuperatorio")
    , @NamedQuery(name = "Notasits.findByObservacion", query = "SELECT n FROM Notasits n WHERE n.observacion = :observacion")
    , @NamedQuery(name = "Notasits.findByNota", query = "SELECT n FROM Notasits n WHERE n.nota = :nota")})
public class Notasits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "parcial1")
    private Integer parcial1;
    @Column(name = "parcial2")
    private Integer parcial2;
    @Column(name = "final")
    private Integer final1;
    @Column(name = "recuperatorio")
    private Integer recuperatorio;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "nota")
    private Integer nota;
    @JoinColumn(name = "contrato_instructorits", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContratoInstructorits contratoInstructorits;

    public Notasits() {
    }

    public Notasits(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParcial1() {
        return parcial1;
    }

    public void setParcial1(Integer parcial1) {
        this.parcial1 = parcial1;
    }

    public Integer getParcial2() {
        return parcial2;
    }

    public void setParcial2(Integer parcial2) {
        this.parcial2 = parcial2;
    }

    public Integer getFinal1() {
        return final1;
    }

    public void setFinal1(Integer final1) {
        this.final1 = final1;
    }

    public Integer getRecuperatorio() {
        return recuperatorio;
    }

    public void setRecuperatorio(Integer recuperatorio) {
        this.recuperatorio = recuperatorio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notasits)) {
            return false;
        }
        Notasits other = (Notasits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Notasits[ id=" + id + " ]";
    }
    
}
