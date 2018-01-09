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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "carrera_habilitada")
@NamedQueries({
    @NamedQuery(name = "CarreraHabilitada.findAll", query = "SELECT c FROM CarreraHabilitada c")
    , @NamedQuery(name = "CarreraHabilitada.findById", query = "SELECT c FROM CarreraHabilitada c WHERE c.id = :id")
    , @NamedQuery(name = "CarreraHabilitada.findByHoraPasantia", query = "SELECT c FROM CarreraHabilitada c WHERE c.horaPasantia = :horaPasantia")
    , @NamedQuery(name = "CarreraHabilitada.findByCupo", query = "SELECT c FROM CarreraHabilitada c WHERE c.cupo = :cupo")})
public class CarreraHabilitada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pasantia")
    private int horaPasantia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupo")
    private int cupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreraHabilitada")
    private List<SemestreHabilitado> semestreHabilitadoList;
    @JoinColumn(name = "carrera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera carrera;
    @JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grupo grupo;

    public CarreraHabilitada() {
    }

    public CarreraHabilitada(Integer id) {
        this.id = id;
    }

    public CarreraHabilitada(Integer id, int horaPasantia, int cupo) {
        this.id = id;
        this.horaPasantia = horaPasantia;
        this.cupo = cupo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHoraPasantia() {
        return horaPasantia;
    }

    public void setHoraPasantia(int horaPasantia) {
        this.horaPasantia = horaPasantia;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public List<SemestreHabilitado> getSemestreHabilitadoList() {
        return semestreHabilitadoList;
    }

    public void setSemestreHabilitadoList(List<SemestreHabilitado> semestreHabilitadoList) {
        this.semestreHabilitadoList = semestreHabilitadoList;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
        if (!(object instanceof CarreraHabilitada)) {
            return false;
        }
        CarreraHabilitada other = (CarreraHabilitada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarreraHabilitada[ id=" + id + " ]";
    }
    
}
