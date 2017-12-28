package Beans;

import Dao.NacionalidadFacade;
import Entidades.Nacionalidad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "nacionalidadBean")
@RequestScoped
public class nacionalidadBean {

    private List<Nacionalidad> nacionalidads;
    private Nacionalidad selectedNacionalidad;
    private Integer Nacionalidadid;

    @EJB
    private NacionalidadFacade nacionalidadFacade;

    public nacionalidadBean() {
        this.selectedNacionalidad = new Nacionalidad();
        this.nacionalidads = new ArrayList<Nacionalidad>();
        int idnacionalidad;
    }

    public List<Nacionalidad> getNacionalidads() {
        this.nacionalidads = nacionalidadFacade.findAll(); //Devuelve de la lista de todos los nacionalidads
        return nacionalidads;
    }

    public void setNacionalidads(List<Nacionalidad> nacionalidads) {
        this.nacionalidads = nacionalidads;
    }

    public Integer getNacionalidadid() {
        return Nacionalidadid;
    }

    public void setNacionalidadid(Integer Nacionalidadid) {
        this.Nacionalidadid = Nacionalidadid;
    }

    public Nacionalidad getSelectedNacionalidad() {
        return selectedNacionalidad;
    }

    public void setSelectedNacionalidad(Nacionalidad selectedNacionalidad) {
        this.selectedNacionalidad = selectedNacionalidad;
    }

    public void EliminarNacionalidad(ActionEvent actionEvent) {
        Nacionalidad nacionalidad = nacionalidadFacade.find(selectedNacionalidad.getId());
        String ms;
        if (nacionalidad.getId()>= 0) {
            nacionalidadFacade.remove(nacionalidad); 
            ms = "Se elimino correctamente el Nacionalidad";
        } else {    
            ms = "¡¡Este Nacionalidad es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarNacionalidad(ActionEvent actionEvent) {
        Nacionalidad nacionalidad = nacionalidadFacade.find(selectedNacionalidad.getId()); 
        String ms;
        if (nacionalidad.getId()>= 0) {
            nacionalidad.setDescripcion(selectedNacionalidad.getDescripcion());
            nacionalidadFacade.edit(nacionalidad); 
            ms = "Se modifico correctamente el Nacionalidad";
        } else {
            ms = "¡¡Este Nacionalidad es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearNacionalidad(ActionEvent actionEvent) {
        String ms;
        if (nacionalidadFacade.NacionalidadUnico(selectedNacionalidad)) {
            Nacionalidad nacionalidad = new Nacionalidad(); 
            nacionalidad.setId(selectedNacionalidad.getId()); 
            nacionalidad.setDescripcion(selectedNacionalidad.getDescripcion());
            nacionalidadFacade.create(nacionalidad); 
            ms = "Se creo correctamente el Nacionalidad";
        }else{
            ms = "Error al creal el Nacionalidad, el Nacionalidad ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Nacionalidad> getListaNacionalidades() {
        return nacionalidadFacade.findAll();
    }
}
