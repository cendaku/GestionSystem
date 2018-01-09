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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "trabajo_practicoits")
@NamedQueries({
    @NamedQuery(name = "TrabajoPracticoits.findAll", query = "SELECT t FROM TrabajoPracticoits t")
    , @NamedQuery(name = "TrabajoPracticoits.findById", query = "SELECT t FROM TrabajoPracticoits t WHERE t.id = :id")
    , @NamedQuery(name = "TrabajoPracticoits.findByNombre", query = "SELECT t FROM TrabajoPracticoits t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TrabajoPracticoits.findByRuta", query = "SELECT t FROM TrabajoPracticoits t WHERE t.ruta = :ruta")
    , @NamedQuery(name = "TrabajoPracticoits.findByPuntajetotal", query = "SELECT t FROM TrabajoPracticoits t WHERE t.puntajetotal = :puntajetotal")})
public class TrabajoPracticoits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "puntajetotal")
    private Integer puntajetotal;
    @JoinColumn(name = "alumno", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "instructor", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "materia_its", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MateriaIts materiaIts;

    public TrabajoPracticoits() {
    }

    public TrabajoPracticoits(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Integer getPuntajetotal() {
        return puntajetotal;
    }

    public void setPuntajetotal(Integer puntajetotal) {
        this.puntajetotal = puntajetotal;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public MateriaIts getMateriaIts() {
        return materiaIts;
    }

    public void setMateriaIts(MateriaIts materiaIts) {
        this.materiaIts = materiaIts;
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
        if (!(object instanceof TrabajoPracticoits)) {
            return false;
        }
        TrabajoPracticoits other = (TrabajoPracticoits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TrabajoPracticoits[ id=" + id + " ]";
    }
    
}
