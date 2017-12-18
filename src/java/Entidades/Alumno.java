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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    , @NamedQuery(name = "Alumno.findByMunicipio", query = "SELECT a FROM Alumno a WHERE a.municipio = :municipio")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ci")
    private Integer ci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
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
    @Basic(optional = false)
    @NotNull
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "municipio")
    private int municipio;
    @ManyToMany(mappedBy = "alumnoList")
    private List<Discapacidad> discapacidadList;
    @JoinTable(name = "ingresantes_cpi", joinColumns = {
        @JoinColumn(name = "alumno", referencedColumnName = "ci")}, inverseJoinColumns = {
        @JoinColumn(name = "cpi_anho", referencedColumnName = "cpi_anho")
        , @JoinColumn(name = "numero_nacional", referencedColumnName = "cpi_numero_nacional")
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera")})
    @ManyToMany
    private List<CarrerasCpi> carrerasCpiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno1")
    private List<InscripcionCpi> inscripcionCpiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno1")
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
    @JoinColumn(name = "situacion_laboral", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SituacionLaboral situacionLaboral;
    @JoinColumn(name = "usuario", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "zona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zona zona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno1")
    private List<InscripcionFpa> inscripcionFpaList;

    public Alumno() {
    }

    public Alumno(Integer ci) {
        this.ci = ci;
    }

    public Alumno(Integer ci, String nombre, String apellido, String celular, Date fechaNacimiento, int municipio) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.municipio = municipio;
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

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public List<Discapacidad> getDiscapacidadList() {
        return discapacidadList;
    }

    public void setDiscapacidadList(List<Discapacidad> discapacidadList) {
        this.discapacidadList = discapacidadList;
    }

    public List<CarrerasCpi> getCarrerasCpiList() {
        return carrerasCpiList;
    }

    public void setCarrerasCpiList(List<CarrerasCpi> carrerasCpiList) {
        this.carrerasCpiList = carrerasCpiList;
    }

    public List<InscripcionCpi> getInscripcionCpiList() {
        return inscripcionCpiList;
    }

    public void setInscripcionCpiList(List<InscripcionCpi> inscripcionCpiList) {
        this.inscripcionCpiList = inscripcionCpiList;
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

    public SituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(SituacionLaboral situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
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

    public List<InscripcionFpa> getInscripcionFpaList() {
        return inscripcionFpaList;
    }

    public void setInscripcionFpaList(List<InscripcionFpa> inscripcionFpaList) {
        this.inscripcionFpaList = inscripcionFpaList;
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
