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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "situacion_laboral")
@NamedQueries({
    @NamedQuery(name = "SituacionLaboral.findAll", query = "SELECT s FROM SituacionLaboral s")
    , @NamedQuery(name = "SituacionLaboral.findById", query = "SELECT s FROM SituacionLaboral s WHERE s.id = :id")
    , @NamedQuery(name = "SituacionLaboral.findByDeseo", query = "SELECT s FROM SituacionLaboral s WHERE s.deseo = :deseo")
    , @NamedQuery(name = "SituacionLaboral.findByEstado", query = "SELECT s FROM SituacionLaboral s WHERE s.estado = :estado")
    , @NamedQuery(name = "SituacionLaboral.findByExperiencia", query = "SELECT s FROM SituacionLaboral s WHERE s.experiencia = :experiencia")
    , @NamedQuery(name = "SituacionLaboral.findByTipoTrabajo", query = "SELECT s FROM SituacionLaboral s WHERE s.tipoTrabajo = :tipoTrabajo")})
public class SituacionLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "deseo")
    private Boolean deseo;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "experiencia")
    private Boolean experiencia;
    @Column(name = "tipo_trabajo")
    private Boolean tipoTrabajo;
    @JoinColumn(name = "horas_trabajo", referencedColumnName = "id")
    @ManyToOne
    private HorasTrabajo horasTrabajo;
    @JoinColumn(name = "salario", referencedColumnName = "id")
    @ManyToOne
    private Salario salario;

    public SituacionLaboral() {
    }

    public SituacionLaboral(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeseo() {
        return deseo;
    }

    public void setDeseo(Boolean deseo) {
        this.deseo = deseo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Boolean experiencia) {
        this.experiencia = experiencia;
    }

    public Boolean getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(Boolean tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public HorasTrabajo getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(HorasTrabajo horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
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
        if (!(object instanceof SituacionLaboral)) {
            return false;
        }
        SituacionLaboral other = (SituacionLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SituacionLaboral[ id=" + id + " ]";
    }
    
}
