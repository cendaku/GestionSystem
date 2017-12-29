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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_motivo")
@NamedQueries({
    @NamedQuery(name = "DetalleMotivo.findAll", query = "SELECT d FROM DetalleMotivo d")
    , @NamedQuery(name = "DetalleMotivo.findByTipoMotivo", query = "SELECT d FROM DetalleMotivo d WHERE d.tipoMotivo = :tipoMotivo")})
public class DetalleMotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_motivo")
    private Integer tipoMotivo;
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "id")
        , @JoinColumn(name = "clase_documento", referencedColumnName = "clase_documento")})
    @ManyToOne(optional = false)
    private Documento documento;
    @JoinColumn(name = "tipo_motivo", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TipoMotivo tipoMotivo1;

    public DetalleMotivo() {
    }

    public DetalleMotivo(Integer tipoMotivo) {
        this.tipoMotivo = tipoMotivo;
    }

    public Integer getTipoMotivo() {
        return tipoMotivo;
    }

    public void setTipoMotivo(Integer tipoMotivo) {
        this.tipoMotivo = tipoMotivo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public TipoMotivo getTipoMotivo1() {
        return tipoMotivo1;
    }

    public void setTipoMotivo1(TipoMotivo tipoMotivo1) {
        this.tipoMotivo1 = tipoMotivo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoMotivo != null ? tipoMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMotivo)) {
            return false;
        }
        DetalleMotivo other = (DetalleMotivo) object;
        if ((this.tipoMotivo == null && other.tipoMotivo != null) || (this.tipoMotivo != null && !this.tipoMotivo.equals(other.tipoMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleMotivo[ tipoMotivo=" + tipoMotivo + " ]";
    }
    
}
