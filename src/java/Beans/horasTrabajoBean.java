/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.HorasTrabajoFacade;
import Entidades.HorasTrabajo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "horasTrabajoBean")
@RequestScoped
public class horasTrabajoBean {

    private List<HorasTrabajo> horasTrabajos;
    private HorasTrabajo selectedHorasTrabajo;
    private Integer HorasTrabajoid;

    @EJB
    private HorasTrabajoFacade horasTrabajoFacade;

    public horasTrabajoBean() {
        this.selectedHorasTrabajo = new HorasTrabajo();
        this.horasTrabajos = new ArrayList<HorasTrabajo>();
        int idhorasTrabajo;
    }

    public List<HorasTrabajo> getHorasTrabajos() {
        this.horasTrabajos = horasTrabajoFacade.findAll(); //Devuelve de la lista de todos los horasTrabajos
        return horasTrabajos;
    }

    public void setHorasTrabajos(List<HorasTrabajo> horasTrabajos) {
        this.horasTrabajos = horasTrabajos;
    }

    public Integer getHorasTrabajoid() {
        return HorasTrabajoid;
    }

    public void setHorasTrabajoid(Integer HorasTrabajoid) {
        this.HorasTrabajoid = HorasTrabajoid;
    }

    public HorasTrabajo getSelectedHorasTrabajo() {
        return selectedHorasTrabajo;
    }

    public void setSelectedHorasTrabajo(HorasTrabajo selectedHorasTrabajo) {
        this.selectedHorasTrabajo = selectedHorasTrabajo;
    }

    public void EliminarHorasTrabajo(ActionEvent actionEvent) {
        HorasTrabajo horasTrabajo = horasTrabajoFacade.find(selectedHorasTrabajo.getId());
        String ms;
        if (horasTrabajo.getId()>= 0) {
            horasTrabajoFacade.remove(horasTrabajo); 
            ms = "Se elimino correctamente el HorasTrabajo";
        } else {    
            ms = "¡¡Este HorasTrabajo es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarHorasTrabajo(ActionEvent actionEvent) {
        HorasTrabajo horasTrabajo = horasTrabajoFacade.find(selectedHorasTrabajo.getId()); 
        String ms;
        if (horasTrabajo.getId()>= 0) {
            horasTrabajo.setDescripcion(selectedHorasTrabajo.getDescripcion());
            horasTrabajoFacade.edit(horasTrabajo); 
            ms = "Se modifico correctamente el HorasTrabajo";
        } else {
            ms = "¡¡Este HorasTrabajo es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearHorasTrabajo(ActionEvent actionEvent) {
        String ms;
        if (horasTrabajoFacade.HorasTrabajoUnico(selectedHorasTrabajo)) {
            HorasTrabajo horasTrabajo = new HorasTrabajo(); 
            horasTrabajo.setId(selectedHorasTrabajo.getId()); 
            horasTrabajo.setDescripcion(selectedHorasTrabajo.getDescripcion());
            horasTrabajoFacade.create(horasTrabajo); 
            ms = "Se creo correctamente el HorasTrabajo";
        }else{
            ms = "Error al creal el HorasTrabajo, el HorasTrabajo ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<HorasTrabajo> getListaHorasTrabajoes() {
        return horasTrabajoFacade.findAll();
    }
}
