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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "horario_cpi")
@NamedQueries({
    @NamedQuery(name = "HorarioCpi.findAll", query = "SELECT h FROM HorarioCpi h")
    , @NamedQuery(name = "HorarioCpi.findByHorario", query = "SELECT h FROM HorarioCpi h WHERE h.horario = :horario")})
public class HorarioCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario")
    private Integer horario;
    @JoinColumn(name = "horario", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Horario horario1;

    public HorarioCpi() {
    }

    public HorarioCpi(Integer horario) {
        this.horario = horario;
    }

    public Integer getHorario() {
        return horario;
    }

    public void setHorario(Integer horario) {
        this.horario = horario;
    }

    public Horario getHorario1() {
        return horario1;
    }

    public void setHorario1(Horario horario1) {
        this.horario1 = horario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horario != null ? horario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioCpi)) {
            return false;
        }
        HorarioCpi other = (HorarioCpi) object;
        if ((this.horario == null && other.horario != null) || (this.horario != null && !this.horario.equals(other.horario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorarioCpi[ horario=" + horario + " ]";
    }
    
}
