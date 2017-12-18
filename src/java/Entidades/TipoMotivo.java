/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "tipo_motivo")
@NamedQueries({
    @NamedQuery(name = "TipoMotivo.findAll", query = "SELECT t FROM TipoMotivo t")
    , @NamedQuery(name = "TipoMotivo.findById", query = "SELECT t FROM TipoMotivo t WHERE t.id = :id")
    , @NamedQuery(name = "TipoMotivo.findByDescripcion", query = "SELECT t FROM TipoMotivo t WHERE t.descripcion = :descripcion")})
public class TipoMotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "detalle_motivo", joinColumns = {
        @JoinColumn(name = "tipo_motivo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "documento", referencedColumnName = "id")})
    @ManyToMany
    private List<Documento> documentoList;

    public TipoMotivo() {
    }

    public TipoMotivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
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
        if (!(object instanceof TipoMotivo)) {
            return false;
        }
        TipoMotivo other = (TipoMotivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoMotivo[ id=" + id + " ]";
    }
    
}
