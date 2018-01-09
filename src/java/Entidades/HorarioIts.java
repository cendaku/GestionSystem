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
@Table(name = "horario_its")
@NamedQueries({
    @NamedQuery(name = "HorarioIts.findAll", query = "SELECT h FROM HorarioIts h")
    , @NamedQuery(name = "HorarioIts.findById", query = "SELECT h FROM HorarioIts h WHERE h.id = :id")})
public class HorarioIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "semestre_habilitado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SemestreHabilitado semestreHabilitado;
    @JoinColumn(name = "horario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horario;

    public HorarioIts() {
    }

    public HorarioIts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SemestreHabilitado getSemestreHabilitado() {
        return semestreHabilitado;
    }

    public void setSemestreHabilitado(SemestreHabilitado semestreHabilitado) {
        this.semestreHabilitado = semestreHabilitado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
        if (!(object instanceof HorarioIts)) {
            return false;
        }
        HorarioIts other = (HorarioIts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorarioIts[ id=" + id + " ]";
    }
    
}
