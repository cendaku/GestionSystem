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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "solicitante")
@NamedQueries({
    @NamedQuery(name = "Solicitante.findAll", query = "SELECT s FROM Solicitante s")
    , @NamedQuery(name = "Solicitante.findById", query = "SELECT s FROM Solicitante s WHERE s.id = :id")
    , @NamedQuery(name = "Solicitante.findByNombreInstitucion", query = "SELECT s FROM Solicitante s WHERE s.nombreInstitucion = :nombreInstitucion")
    , @NamedQuery(name = "Solicitante.findByTelefonoContacto", query = "SELECT s FROM Solicitante s WHERE s.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Solicitante.findByNombreRecepcion", query = "SELECT s FROM Solicitante s WHERE s.nombreRecepcion = :nombreRecepcion")})
public class Solicitante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre_institucion")
    private String nombreInstitucion;
    @Size(max = 50)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Size(max = 50)
    @Column(name = "nombre_recepcion")
    private String nombreRecepcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitantes")
    private List<Documento> documentoList;

    public Solicitante() {
    }

    public Solicitante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombreRecepcion() {
        return nombreRecepcion;
    }

    public void setNombreRecepcion(String nombreRecepcion) {
        this.nombreRecepcion = nombreRecepcion;
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
        if (!(object instanceof Solicitante)) {
            return false;
        }
        Solicitante other = (Solicitante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Solicitante[ id=" + id + " ]";
    }
    
}
