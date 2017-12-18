/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "certificado")
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c")
    , @NamedQuery(name = "Certificado.findById", query = "SELECT c FROM Certificado c WHERE c.id = :id")
    , @NamedQuery(name = "Certificado.findByEntregado", query = "SELECT c FROM Certificado c WHERE c.entregado = :entregado")
    , @NamedQuery(name = "Certificado.findByFechaRecibido", query = "SELECT c FROM Certificado c WHERE c.fechaRecibido = :fechaRecibido")
    , @NamedQuery(name = "Certificado.findByFechaEntregado", query = "SELECT c FROM Certificado c WHERE c.fechaEntregado = :fechaEntregado")
    , @NamedQuery(name = "Certificado.findByRetiradoPor", query = "SELECT c FROM Certificado c WHERE c.retiradoPor = :retiradoPor")})
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "entregado")
    private String entregado;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibido;
    @Column(name = "fecha_entregado")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregado;
    @Size(max = 80)
    @Column(name = "retirado_por")
    private String retiradoPor;
    @JoinColumns({
        @JoinColumn(name = "curso", referencedColumnName = "curso")
        , @JoinColumn(name = "alumno", referencedColumnName = "alumno")})
    @ManyToOne(optional = false)
    private InscripcionFpa inscripcionFpa;

    public Certificado() {
        this.id=0;
        this.inscripcionFpa = new InscripcionFpa();
    }

    public Certificado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public String getRetiradoPor() {
        return retiradoPor;
    }

    public void setRetiradoPor(String retiradoPor) {
        this.retiradoPor = retiradoPor;
    }

    public InscripcionFpa getInscripcionFpa() {
        return inscripcionFpa;
    }

    public void setInscripcionFpa(InscripcionFpa inscripcionFpa) {
        this.inscripcionFpa = inscripcionFpa;
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
        if (!(object instanceof Certificado)) {
            return false;
        }
        Certificado other = (Certificado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Certificado[ id=" + id + " ]";
    }
    
}
