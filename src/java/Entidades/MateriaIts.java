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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "materia_its")
@NamedQueries({
    @NamedQuery(name = "MateriaIts.findAll", query = "SELECT m FROM MateriaIts m")
    , @NamedQuery(name = "MateriaIts.findById", query = "SELECT m FROM MateriaIts m WHERE m.id = :id")
    , @NamedQuery(name = "MateriaIts.findByNombre", query = "SELECT m FROM MateriaIts m WHERE m.nombre = :nombre")})
public class MateriaIts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cargahoraria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CargaHorariaits cargahoraria;
    @JoinColumns({
        @JoinColumn(name = "sem_habi_num", referencedColumnName = "numero_nacional")
        , @JoinColumn(name = "sem_ha_anho", referencedColumnName = "anho")
        , @JoinColumn(name = "grupo", referencedColumnName = "grupo")
        , @JoinColumn(name = "carrera", referencedColumnName = "carrera")
        , @JoinColumn(name = "semestre", referencedColumnName = "semestre")})
    @ManyToOne(optional = false)
    private SemestreHabilitado semestreHabilitado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaIts1")
    private List<ContratoInstructorits> contratoInstructoritsList;

    public MateriaIts() {
    }

    public MateriaIts(Integer id) {
        this.id = id;
    }

    public MateriaIts(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public CargaHorariaits getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(CargaHorariaits cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public SemestreHabilitado getSemestreHabilitado() {
        return semestreHabilitado;
    }

    public void setSemestreHabilitado(SemestreHabilitado semestreHabilitado) {
        this.semestreHabilitado = semestreHabilitado;
    }

    public List<ContratoInstructorits> getContratoInstructoritsList() {
        return contratoInstructoritsList;
    }

    public void setContratoInstructoritsList(List<ContratoInstructorits> contratoInstructoritsList) {
        this.contratoInstructoritsList = contratoInstructoritsList;
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
        if (!(object instanceof MateriaIts)) {
            return false;
        }
        MateriaIts other = (MateriaIts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MateriaIts[ id=" + id + " ]";
    }
    
}
