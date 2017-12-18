/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author administrador
 */
@Entity
@Table(name = "carreras_cpi")
@NamedQueries({
    @NamedQuery(name = "CarrerasCpi.findAll", query = "SELECT c FROM CarrerasCpi c")
    , @NamedQuery(name = "CarrerasCpi.findByCpiAnho", query = "SELECT c FROM CarrerasCpi c WHERE c.carrerasCpiPK.cpiAnho = :cpiAnho")
    , @NamedQuery(name = "CarrerasCpi.findByCpiNumeroNacional", query = "SELECT c FROM CarrerasCpi c WHERE c.carrerasCpiPK.cpiNumeroNacional = :cpiNumeroNacional")
    , @NamedQuery(name = "CarrerasCpi.findByCarrera", query = "SELECT c FROM CarrerasCpi c WHERE c.carrerasCpiPK.carrera = :carrera")})
public class CarrerasCpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarrerasCpiPK carrerasCpiPK;
    @ManyToMany(mappedBy = "carrerasCpiList")
    private List<Alumno> alumnoList;
    @JoinColumn(name = "carrera", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera1;
    @JoinColumns({
        @JoinColumn(name = "cpi_anho", referencedColumnName = "anho", insertable = false, updatable = false)
        , @JoinColumn(name = "cpi_numero_nacional", referencedColumnName = "numero_nacional", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PdCpi pdCpi;

    public CarrerasCpi() {
    }

    public CarrerasCpi(CarrerasCpiPK carrerasCpiPK) {
        this.carrerasCpiPK = carrerasCpiPK;
    }

    public CarrerasCpi(int cpiAnho, int cpiNumeroNacional, int carrera) {
        this.carrerasCpiPK = new CarrerasCpiPK(cpiAnho, cpiNumeroNacional, carrera);
    }

    public CarrerasCpiPK getCarrerasCpiPK() {
        return carrerasCpiPK;
    }

    public void setCarrerasCpiPK(CarrerasCpiPK carrerasCpiPK) {
        this.carrerasCpiPK = carrerasCpiPK;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Carrera getCarrera1() {
        return carrera1;
    }

    public void setCarrera1(Carrera carrera1) {
        this.carrera1 = carrera1;
    }

    public PdCpi getPdCpi() {
        return pdCpi;
    }

    public void setPdCpi(PdCpi pdCpi) {
        this.pdCpi = pdCpi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrerasCpiPK != null ? carrerasCpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrerasCpi)) {
            return false;
        }
        CarrerasCpi other = (CarrerasCpi) object;
        if ((this.carrerasCpiPK == null && other.carrerasCpiPK != null) || (this.carrerasCpiPK != null && !this.carrerasCpiPK.equals(other.carrerasCpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CarrerasCpi[ carrerasCpiPK=" + carrerasCpiPK + " ]";
    }
    
}
