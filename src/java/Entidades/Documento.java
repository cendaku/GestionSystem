/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findById", query = "SELECT d FROM Documento d WHERE d.documentoPK.id = :id")
    , @NamedQuery(name = "Documento.findByClaseDocumento", query = "SELECT d FROM Documento d WHERE d.documentoPK.claseDocumento = :claseDocumento")
    , @NamedQuery(name = "Documento.findByEstadoSolicitud", query = "SELECT d FROM Documento d WHERE d.estadoSolicitud = :estadoSolicitud")
    , @NamedQuery(name = "Documento.findByFechaEnviado", query = "SELECT d FROM Documento d WHERE d.fechaEnviado = :fechaEnviado")
    , @NamedQuery(name = "Documento.findByFechaRecibido", query = "SELECT d FROM Documento d WHERE d.fechaRecibido = :fechaRecibido")
    , @NamedQuery(name = "Documento.findByRevisionDireccion", query = "SELECT d FROM Documento d WHERE d.revisionDireccion = :revisionDireccion")
    , @NamedQuery(name = "Documento.findByObservacionDireccion", query = "SELECT d FROM Documento d WHERE d.observacionDireccion = :observacionDireccion")
    , @NamedQuery(name = "Documento.findByRuta", query = "SELECT d FROM Documento d WHERE d.ruta = :ruta")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPK documentoPK;
    @Column(name = "estado_solicitud")
    private Boolean estadoSolicitud;
    @Column(name = "fecha_enviado")
    @Temporal(TemporalType.DATE)
    private Date fechaEnviado;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibido;
    @Column(name = "revision_direccion")
    private Boolean revisionDireccion;
    @Size(max = 120)
    @Column(name = "observacion_direccion")
    private String observacionDireccion;
    @Size(max = 120)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "usuario", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "solicitantes", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitante solicitantes;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documento")
    private List<DetalleMotivo> detalleMotivoList;

    public Documento() {
    }

    public Documento(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(int id, boolean claseDocumento) {
        this.documentoPK = new DocumentoPK(id, claseDocumento);
    }

    public DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Boolean getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Boolean estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Date getFechaEnviado() {
        return fechaEnviado;
    }

    public void setFechaEnviado(Date fechaEnviado) {
        this.fechaEnviado = fechaEnviado;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Boolean getRevisionDireccion() {
        return revisionDireccion;
    }

    public void setRevisionDireccion(Boolean revisionDireccion) {
        this.revisionDireccion = revisionDireccion;
    }

    public String getObservacionDireccion() {
        return observacionDireccion;
    }

    public void setObservacionDireccion(String observacionDireccion) {
        this.observacionDireccion = observacionDireccion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitante getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(Solicitante solicitantes) {
        this.solicitantes = solicitantes;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<DetalleMotivo> getDetalleMotivoList() {
        return detalleMotivoList;
    }

    public void setDetalleMotivoList(List<DetalleMotivo> detalleMotivoList) {
        this.detalleMotivoList = detalleMotivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
