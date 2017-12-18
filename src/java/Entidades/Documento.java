/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findById", query = "SELECT d FROM Documento d WHERE d.id = :id")
    , @NamedQuery(name = "Documento.findByEstadoSolicitud", query = "SELECT d FROM Documento d WHERE d.estadoSolicitud = :estadoSolicitud")
    , @NamedQuery(name = "Documento.findByFechaEnviado", query = "SELECT d FROM Documento d WHERE d.fechaEnviado = :fechaEnviado")
    , @NamedQuery(name = "Documento.findByFechaRecibido", query = "SELECT d FROM Documento d WHERE d.fechaRecibido = :fechaRecibido")
    , @NamedQuery(name = "Documento.findByRevisionDireccion", query = "SELECT d FROM Documento d WHERE d.revisionDireccion = :revisionDireccion")
    , @NamedQuery(name = "Documento.findByObservacionDireccion", query = "SELECT d FROM Documento d WHERE d.observacionDireccion = :observacionDireccion")
    , @NamedQuery(name = "Documento.findByRuta", query = "SELECT d FROM Documento d WHERE d.ruta = :ruta")
    , @NamedQuery(name = "Documento.findByClaseDocumento", query = "SELECT d FROM Documento d WHERE d.claseDocumento = :claseDocumento")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "clase_documento")
    private Boolean claseDocumento;
    @ManyToMany(mappedBy = "documentoList")
    private List<TipoMotivo> tipoMotivoList;
    @JoinColumn(name = "usuario_ci", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Usuario usuarioCi;
    @JoinColumn(name = "solicitantes", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitante solicitantes;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public Documento() {
        this.id=0;
        this.solicitantes = new Solicitante();
        this.tipoDocumento = new TipoDocumento();
        this.usuarioCi = new Usuario();
    }

    public Documento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getClaseDocumento() {
        return claseDocumento;
    }

    public void setClaseDocumento(Boolean claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    public List<TipoMotivo> getTipoMotivoList() {
        return tipoMotivoList;
    }

    public void setTipoMotivoList(List<TipoMotivo> tipoMotivoList) {
        this.tipoMotivoList = tipoMotivoList;
    }

    public Usuario getUsuarioCi() {
        return usuarioCi;
    }

    public void setUsuarioCi(Usuario usuarioCi) {
        this.usuarioCi = usuarioCi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Documento[ id=" + id + " ]";
    }
    
}
