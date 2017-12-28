/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.DiscapacidadFacade;
import Entidades.Discapacidad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "discapacidadBean")
@RequestScoped
public class discapacidadBean {

    private List<Discapacidad> discapacidads;
    private Discapacidad selectedDiscapacidad;
    private Integer Discapacidadid;

    @EJB
    private DiscapacidadFacade discapacidadFacade;

    public discapacidadBean() {
        this.selectedDiscapacidad = new Discapacidad();
        this.discapacidads = new ArrayList<Discapacidad>();
        int iddiscapacidad;
    }

    public List<Discapacidad> getDiscapacidads() {
        this.discapacidads = discapacidadFacade.findAll(); //Devuelve de la lista de todos los discapacidads
        return discapacidads;
    }

    public void setDiscapacidads(List<Discapacidad> discapacidads) {
        this.discapacidads = discapacidads;
    }

    public Integer getDiscapacidadid() {
        return Discapacidadid;
    }

    public void setDiscapacidadid(Integer Discapacidadid) {
        this.Discapacidadid = Discapacidadid;
    }

    public Discapacidad getSelectedDiscapacidad() {
        return selectedDiscapacidad;
    }

    public void setSelectedDiscapacidad(Discapacidad selectedDiscapacidad) {
        this.selectedDiscapacidad = selectedDiscapacidad;
    }

    public void EliminarDiscapacidad(ActionEvent actionEvent) {
        Discapacidad discapacidad = discapacidadFacade.find(selectedDiscapacidad.getId());
        String ms;
        if (discapacidad.getId()>= 0) {
            discapacidadFacade.remove(discapacidad); 
            ms = "Se elimino correctamente el Discapacidad";
        } else {    
            ms = "¡¡Este Discapacidad es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarDiscapacidad(ActionEvent actionEvent) {
        Discapacidad discapacidad = discapacidadFacade.find(selectedDiscapacidad.getId()); 
        String ms;
        if (discapacidad.getId()>= 0) {
            discapacidad.setDescripcion(selectedDiscapacidad.getDescripcion());
            discapacidadFacade.edit(discapacidad); 
            ms = "Se modifico correctamente el Discapacidad";
        } else {
            ms = "¡¡Este Discapacidad es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearDiscapacidad(ActionEvent actionEvent) {
        String ms;
        if (discapacidadFacade.DiscapacidadUnico(selectedDiscapacidad)) {
            Discapacidad discapacidad = new Discapacidad(); 
            discapacidad.setId(selectedDiscapacidad.getId()); 
            discapacidad.setDescripcion(selectedDiscapacidad.getDescripcion());
            discapacidadFacade.create(discapacidad); 
            ms = "Se creo correctamente el Discapacidad";
        }else{
            ms = "Error al creal el Discapacidad, el Discapacidad ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Discapacidad> getListaDiscapacidades() {
        return discapacidadFacade.findAll();
    }
}
