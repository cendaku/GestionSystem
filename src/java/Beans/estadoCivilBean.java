package Beans;

import Dao.EstadoCivilFacade;
import Entidades.EstadoCivil;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "estadoCivilBean")
@RequestScoped
public class estadoCivilBean {

    private List<EstadoCivil> estadoCivils;
    private EstadoCivil selectedEstadoCivil;
    private Integer EstadoCivilid;

    @EJB
    private EstadoCivilFacade estadoCivilFacade;

    public estadoCivilBean() {
        this.selectedEstadoCivil = new EstadoCivil();
        this.estadoCivils = new ArrayList<EstadoCivil>();
        int idestadoCivil;
    }

    public List<EstadoCivil> getEstadoCivils() {
        this.estadoCivils = estadoCivilFacade.findAll(); //Devuelve de la lista de todos los estadoCivils
        return estadoCivils;
    }

    public void setEstadoCivils(List<EstadoCivil> estadoCivils) {
        this.estadoCivils = estadoCivils;
    }

    public Integer getEstadoCivilid() {
        return EstadoCivilid;
    }

    public void setEstadoCivilid(Integer EstadoCivilid) {
        this.EstadoCivilid = EstadoCivilid;
    }

    public EstadoCivil getSelectedEstadoCivil() {
        return selectedEstadoCivil;
    }

    public void setSelectedEstadoCivil(EstadoCivil selectedEstadoCivil) {
        this.selectedEstadoCivil = selectedEstadoCivil;
    }

    public void EliminarEstadoCivil(ActionEvent actionEvent) {
        EstadoCivil estadoCivil = estadoCivilFacade.find(selectedEstadoCivil.getId());
        String ms;
        if (estadoCivil.getId()>= 0) {
            estadoCivilFacade.remove(estadoCivil); 
            ms = "Se elimino correctamente el EstadoCivil";
        } else {    
            ms = "¡¡Este EstadoCivil es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarEstadoCivil(ActionEvent actionEvent) {
        EstadoCivil estadoCivil = estadoCivilFacade.find(selectedEstadoCivil.getId()); 
        String ms;
        if (estadoCivil.getId()>= 0) {
            estadoCivil.setDescripcion(selectedEstadoCivil.getDescripcion());
            estadoCivilFacade.edit(estadoCivil); 
            ms = "Se modifico correctamente el EstadoCivil";
        } else {
            ms = "¡¡Este EstadoCivil es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearEstadoCivil(ActionEvent actionEvent) {
        String ms;
        if (estadoCivilFacade.EstadoCivilUnico(selectedEstadoCivil)) {
            EstadoCivil estadoCivil = new EstadoCivil(); 
            estadoCivil.setId(selectedEstadoCivil.getId()); 
            estadoCivil.setDescripcion(selectedEstadoCivil.getDescripcion());
            estadoCivilFacade.create(estadoCivil); 
            ms = "Se creo correctamente el EstadoCivil";
        }else{
            ms = "Error al creal el EstadoCivil, el EstadoCivil ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<EstadoCivil> getListaEstadoCiviles() {
        return estadoCivilFacade.findAll();
    }
}
