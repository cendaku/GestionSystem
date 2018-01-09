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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "alumno")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByCi", query = "SELECT a FROM Alumno a WHERE a.ci = :ci")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByApellido", query = "SELECT a FROM Alumno a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Alumno.findByCelular", query = "SELECT a FROM Alumno a WHERE a.celular = :celular")
    , @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Alumno.findByEmail", query = "SELECT a FROM Alumno a WHERE a.email = :email")
    , @NamedQuery(name = "Alumno.findByTelefono", query = "SELECT a FROM Alumno a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumno.findByFechaNacimiento", query = "SELECT a FROM Alumno a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Alumno.findByNombreContacto", query = "SELECT a FROM Alumno a WHERE a.nombreContacto = :nombreContacto")
    , @NamedQuery(name = "Alumno.findByTelefonoContacto", query = "SELECT a FROM Alumno a WHERE a.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Alumno.findByRuta", query = "SELECT a FROM Alumno a WHERE a.ruta = :ruta")
    , @NamedQuery(name = "Alumno.findByEstado", query = "SELECT a FROM Alumno a WHERE a.estado = :estado")
    , @NamedQuery(name = "Alumno.findByDeseo", query = "SELECT a FROM Alumno a WHERE a.deseo = :deseo")
    , @NamedQuery(name = "Alumno.findByExperiencia", query = "SELECT a FROM Alumno a WHERE a.experiencia = :experiencia")
    , @NamedQuery(name = "Alumno.findByTipoTrabajo", query = "SELECT a FROM Alumno a WHERE a.tipoTrabajo = :tipoTrabajo")
    , @NamedQuery(name = "Alumno.findByHorasTrabajo", query = "SELECT a FROM Alumno a WHERE a.horasTrabajo = :horasTrabajo")
    , @NamedQuery(name = "Alumno.findBySalario", query = "SELECT a FROM Alumno a WHERE a.salario = :salario")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ci")
    private Integer ci;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "celular")
    private String celular;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Size(max = 45)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Size(max = 45)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "deseo")
    private Boolean deseo;
    @Column(name = "experiencia")
    private Boolean experiencia;
    @Column(name = "tipo_trabajo")
    private Boolean tipoTrabajo;
    @Column(name = "horas_trabajo")
    private Integer horasTrabajo;
    @Column(name = "salario")
    private Integer salario;
    @ManyToMany(mappedBy = "alumnoList")
    private List<Discapacidad> discapacidadList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno1")
    private IngresantesCpi ingresantesCpi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno1")
    private List<InscripcionFpa> inscripcionFpaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno1")
    private InscripcionCpi inscripcionCpi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<TrabajoPracticoits> trabajoPracticoitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<InscripcionIts> inscripcionItsList;
    @JoinColumn(name = "estado_academico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoAcademico estadoAcademico;
    @JoinColumn(name = "estado_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "localidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Localidad localidad;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @JoinColumn(name = "sexo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sexo sexo;
    @JoinColumn(name = "usuario", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "zona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zona zona;

    public Alumno() {
    }

    public Alumno(Integer ci) {
        this.ci = ci;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getDeseo() {
        return deseo;
    }

    public void setDeseo(Boolean deseo) {
        this.deseo = deseo;
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

    public Integer getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(Integer horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public List<Discapacidad> getDiscapacidadList() {
        return discapacidadList;
    }

    public void setDiscapacidadList(List<Discapacidad> discapacidadList) {
        this.discapacidadList = discapacidadList;
    }

    public IngresantesCpi getIngresantesCpi() {
        return ingresantesCpi;
    }

    public void setIngresantesCpi(IngresantesCpi ingresantesCpi) {
        this.ingresantesCpi = ingresantesCpi;
    }

    public List<InscripcionFpa> getInscripcionFpaList() {
        return inscripcionFpaList;
    }

    public void setInscripcionFpaList(List<InscripcionFpa> inscripcionFpaList) {
        this.inscripcionFpaList = inscripcionFpaList;
    }

    public InscripcionCpi getInscripcionCpi() {
        return inscripcionCpi;
    }

    public void setInscripcionCpi(InscripcionCpi inscripcionCpi) {
        this.inscripcionCpi = inscripcionCpi;
    }

    public List<TrabajoPracticoits> getTrabajoPracticoitsList() {
        return trabajoPracticoitsList;
    }

    public void setTrabajoPracticoitsList(List<TrabajoPracticoits> trabajoPracticoitsList) {
        this.trabajoPracticoitsList = trabajoPracticoitsList;
    }

    public List<InscripcionIts> getInscripcionItsList() {
        return inscripcionItsList;
    }

    public void setInscripcionItsList(List<InscripcionIts> inscripcionItsList) {
        this.inscripcionItsList = inscripcionItsList;
    }

    public EstadoAcademico getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(EstadoAcademico estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ci != null ? ci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.ci == null && other.ci != null) || (this.ci != null && !this.ci.equals(other.ci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Alumno[ ci=" + ci + " ]";
    }
    
}
