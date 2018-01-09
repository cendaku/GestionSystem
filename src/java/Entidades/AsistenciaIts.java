/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "asistencia_its")
@NamedQueries({
    @NamedQuery(name = "AsistenciaIts.findAll", query = "SELECT a FROM AsistenciaIts a")
    , @NamedQuery(name = "AsistenciaIts.findById", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.id = :id")
    , @NamedQuery(name = "AsistenciaIts.findByFecha", query = "SELECT a FROM AsistenciaIts a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "AsistenciaIts.findByPresencia", query = "SELECT a FROM AsistenciaIts a WHERE a.presencia = :presencia")
    , @NamedQuery(name = "AsistenciaIts.findByContratoInstructorits", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.contratoInstructorits = :contratoInstructorits")
    , @NamedQuery(name = "AsistenciaIts.findByMateriaIts", query = "SELECT a FROM AsistenciaIts a WHERE a.asistenciaItsPK.materiaIts = :materiaIts")})
public class AsistenciaIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaItsPK asistenciaItsPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "presencia")
    private Integer presencia;
    @JoinColumn(name = "inscripcion_its_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InscripcionIts inscripcionItsId;

    public AsistenciaIts() {
    }

    public AsistenciaIts(AsistenciaItsPK asistenciaItsPK) {
        this.asistenciaItsPK = asistenciaItsPK;
    }

    public AsistenciaIts(int id, int contratoInstructorits, int materiaIts) {
        this.asistenciaItsPK = new AsistenciaItsPK(id, contratoInstructorits, materiaIts);
    }

    public AsistenciaItsPK getAsistenciaItsPK() {
        return asistenciaItsPK;
    }

    public void setAsistenciaItsPK(AsistenciaItsPK asistenciaItsPK) {
        this.asistenciaItsPK = asistenciaItsPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPresencia() {
        return presencia;
    }

    public void setPresencia(Integer presencia) {
        this.presencia = presencia;
    }

    public InscripcionIts getInscripcionItsId() {
        return inscripcionItsId;
    }

    public void setInscripcionItsId(InscripcionIts inscripcionItsId) {
        this.inscripcionItsId = inscripcionItsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaItsPK != null ? asistenciaItsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaIts)) {
            return false;
        }
        AsistenciaIts other = (AsistenciaIts) object;
        if ((this.asistenciaItsPK == null && other.asistenciaItsPK != null) || (this.asistenciaItsPK != null && !this.asistenciaItsPK.equals(other.asistenciaItsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsistenciaIts[ asistenciaItsPK=" + asistenciaItsPK + " ]";
    }
    
}
