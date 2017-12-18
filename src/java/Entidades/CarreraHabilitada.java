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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "CarreraHabilitada.findByGrupo", query = "SELECT c FROM CarreraHabilitada c WHERE c.carreraHabilitadaPK.grupo = :grupo")
    , @NamedQuery(name = "CarreraHabilitada.findByCarrera", query = "SELECT c FROM CarreraHabilitada c WHERE c.carreraHabilitadaPK.carrera = :carrera")
    , @NamedQuery(name = "CarreraHabilitada.findByHoraPasantia", query = "SELECT c FROM CarreraHabilitada c WHERE c.horaPasantia = :horaPasantia")
    , @NamedQuery(name = "CarreraHabilitada.findByCupo", query = "SELECT c FROM CarreraHabilitada c WHERE c.cupo = :cupo")})
public class CarreraHabilitada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarreraHabilitadaPK carreraHabilitadaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pasantia")
    private int horaPasantia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupo")
    private int cupo;
    @JoinColumn(name = "carrera", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera1;
    @JoinColumn(name = "grupo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grupo grupo1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreraHabilitada")
    private List<SemestreHabilitado> semestreHabilitadoList;

    public CarreraHabilitada() {
        this.carrera1 = new Carrera();
        this.grupo1 = new Grupo();
    }

    public CarreraHabilitada(CarreraHabilitadaPK carreraHabilitadaPK) {
        this.carreraHabilitadaPK = carreraHabilitadaPK;
    }

    public CarreraHabilitada(CarreraHabilitadaPK carreraHabilitadaPK, int horaPasantia, int cupo) {
        this.carreraHabilitadaPK = carreraHabilitadaPK;
        this.horaPasantia = horaPasantia;
        this.cupo = cupo;
    }

    public CarreraHabilitada(int grupo, int carrera) {
        this.carreraHabilitadaPK = new CarreraHabilitadaPK(grupo, carrera);
    }

    public CarreraHabilitadaPK getCarreraHabilitadaPK() {
        return carreraHabilitadaPK;
    }

    public void setCarreraHabilitadaPK(CarreraHabilitadaPK carreraHabilitadaPK) {
        this.carreraHabilitadaPK = carreraHabilitadaPK;
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

    public Carrera getCarrera1() {
        return carrera1;
    }

    public void setCarrera1(Carrera carrera1) {
        this.carrera1 = carrera1;
    }

    public Grupo getGrupo1() {
        return grupo1;
    }

    public void setGrupo1(Grupo grupo1) {
        this.grupo1 = grupo1;
    }

    public List<SemestreHabilitado> getSemestreHabilitadoList() {
        return semestreHabilitadoList;
    }

    public void setSemestreHabilitadoList(List<SemestreHabilitado> semestreHabilitadoList) {
        this.semestreHabilitadoList = semestreHabilitadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carreraHabilitadaPK != null ? carreraHabilitadaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarreraHabilitada)) {
            return false;
        }
        CarreraHabilitada other = (CarreraHabilitada) object;
        if ((this.carreraHabilitadaPK == null && other.carreraHabilitadaPK != null) || (this.carreraHabilitadaPK != null && !this.carreraHabilitadaPK.equals(other.carreraHabilitadaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarreraHabilitada[ carreraHabilitadaPK=" + carreraHabilitadaPK + " ]";
    }
    
}
