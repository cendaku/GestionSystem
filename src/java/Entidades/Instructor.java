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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "instructor")
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findByCi", query = "SELECT i FROM Instructor i WHERE i.ci = :ci")
    , @NamedQuery(name = "Instructor.findByNombre", query = "SELECT i FROM Instructor i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instructor.findByApellido", query = "SELECT i FROM Instructor i WHERE i.apellido = :apellido")
    , @NamedQuery(name = "Instructor.findByEmail", query = "SELECT i FROM Instructor i WHERE i.email = :email")
    , @NamedQuery(name = "Instructor.findByRuta", query = "SELECT i FROM Instructor i WHERE i.ruta = :ruta")
    , @NamedQuery(name = "Instructor.findByTelefono", query = "SELECT i FROM Instructor i WHERE i.telefono = :telefono")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ci")
    private Integer ci;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 80)
    @Column(name = "ruta")
    private String ruta;
    @Size(max = 80)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<TrabajoPracticoits> trabajoPracticoitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor1")
    private List<ContratoInstructorcpi> contratoInstructorcpiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<ContratoInstructorits> contratoInstructoritsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<HorarioInstructorits> horarioInstructoritsList;
    @JoinColumn(name = "sexo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sexo sexo;
    @JoinColumn(name = "estado_academico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoAcademico estadoAcademico;
    @JoinColumn(name = "estado_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "municipio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipio municipio;
    @JoinColumn(name = "usuario", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<Curso> cursoList;

    public Instructor() {
    }

    public Instructor(Integer ci) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<TrabajoPracticoits> getTrabajoPracticoitsList() {
        return trabajoPracticoitsList;
    }

    public void setTrabajoPracticoitsList(List<TrabajoPracticoits> trabajoPracticoitsList) {
        this.trabajoPracticoitsList = trabajoPracticoitsList;
    }

    public List<ContratoInstructorcpi> getContratoInstructorcpiList() {
        return contratoInstructorcpiList;
    }

    public void setContratoInstructorcpiList(List<ContratoInstructorcpi> contratoInstructorcpiList) {
        this.contratoInstructorcpiList = contratoInstructorcpiList;
    }

    public List<ContratoInstructorits> getContratoInstructoritsList() {
        return contratoInstructoritsList;
    }

    public void setContratoInstructoritsList(List<ContratoInstructorits> contratoInstructoritsList) {
        this.contratoInstructoritsList = contratoInstructoritsList;
    }

    public List<HorarioInstructorits> getHorarioInstructoritsList() {
        return horarioInstructoritsList;
    }

    public void setHorarioInstructoritsList(List<HorarioInstructorits> horarioInstructoritsList) {
        this.horarioInstructoritsList = horarioInstructoritsList;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
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
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.ci == null && other.ci != null) || (this.ci != null && !this.ci.equals(other.ci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Instructor[ ci=" + ci + " ]";
    }
    
}
