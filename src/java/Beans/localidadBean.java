/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Dao.MunicipioFacade;
import Dao.LocalidadFacade;
import Entidades.Localidad;
import Entidades.Municipio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

@Named(value = "localidadBean")
@RequestScoped
public class localidadBean {

    private List<Localidad> localidads;
    private Localidad selectedLocalidad;
    private Integer Municipioid;   
    private List<Entidades.Municipio> municipios;
   


    @EJB
    LocalidadFacade localidadFacade;
    @EJB
    MunicipioFacade municipioFacade;
    @EJB
    private LocalidadFacade localidadEJB;

    public localidadBean() {
        this.selectedLocalidad = new Localidad();
        this.localidads = new ArrayList<>();

    }

   @PostConstruct
   public void init() {
   this.municipios = municipioFacade.findAll();
   }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

 
    
   
    public List<Localidad> getLocalidads() {
        this.localidads = localidadFacade.findAll();
        return localidads;
    }

    public void setLocalidads(List<Localidad> localidads) {
        this.localidads = localidads;
    }

    public Integer getMunicipioid() {
        return Municipioid;
    }

    public void setMunicipioid(Integer Municipioid) {
        this.Municipioid = Municipioid;
    }

    public Localidad getSelectedLocalidad() {
        return selectedLocalidad;
    }
    
    

    public void setSelectedLocalidad(Localidad selectedLocalidad) {
        this.selectedLocalidad = selectedLocalidad;
    }

    public void EliminarLocalidad(ActionEvent actionEvent) {
        localidadFacade.remove(localidadFacade.find(selectedLocalidad.getId()));
    
    }
    
    public void ModificarLocalidad(ActionEvent actionEvent) {
        this.selectedLocalidad.setMunicipio(this.municipioFacade.find(this.Municipioid));
        localidadFacade.edit(selectedLocalidad);
    }

    public void CrearLocalidad(ActionEvent actionEvent) {
        this.selectedLocalidad.setMunicipio(this.municipioFacade.find(this.Municipioid));
        localidadFacade.create(selectedLocalidad);
    }
    
    public void seleccionarLocalidad(Integer id){
        this.selectedLocalidad=this.localidadFacade.find(id);
        this.Municipioid=this.selectedLocalidad.getMunicipio().getId();
    }
}