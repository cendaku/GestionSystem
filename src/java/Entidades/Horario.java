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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findById", query = "SELECT h FROM Horario h WHERE h.id = :id")
    , @NamedQuery(name = "Horario.findByDia", query = "SELECT h FROM Horario h WHERE h.dia = :dia")
    , @NamedQuery(name = "Horario.findByHoraInicio", query = "SELECT h FROM Horario h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "Horario.findByHorarioFinal", query = "SELECT h FROM Horario h WHERE h.horarioFinal = :horarioFinal")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "dia")
    private String dia;
    @Size(max = 45)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Size(max = 45)
    @Column(name = "horario_final")
    private String horarioFinal;
    @ManyToMany(mappedBy = "horarioList")
    private List<ContratoInstructorcpi> contratoInstructorcpiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private List<HorarioIts> horarioItsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private List<HorarioInstructorits> horarioInstructoritsList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "horario1")
    private HorarioCpi horarioCpi;

    public Horario() {
    }

    public Horario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public List<ContratoInstructorcpi> getContratoInstructorcpiList() {
        return contratoInstructorcpiList;
    }

    public void setContratoInstructorcpiList(List<ContratoInstructorcpi> contratoInstructorcpiList) {
        this.contratoInstructorcpiList = contratoInstructorcpiList;
    }

    public List<HorarioIts> getHorarioItsList() {
        return horarioItsList;
    }

    public void setHorarioItsList(List<HorarioIts> horarioItsList) {
        this.horarioItsList = horarioItsList;
    }

    public List<HorarioInstructorits> getHorarioInstructoritsList() {
        return horarioInstructoritsList;
    }

    public void setHorarioInstructoritsList(List<HorarioInstructorits> horarioInstructoritsList) {
        this.horarioInstructoritsList = horarioInstructoritsList;
    }

    public HorarioCpi getHorarioCpi() {
        return horarioCpi;
    }

    public void setHorarioCpi(HorarioCpi horarioCpi) {
        this.horarioCpi = horarioCpi;
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Horario[ id=" + id + " ]";
    }
    
}
