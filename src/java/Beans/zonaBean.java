package Beans;

import Dao.ZonaFacade;
import Entidades.Zona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "zonaBean")
@RequestScoped
public class zonaBean {

    private List<Zona> zonas;
    private Zona selectedZona;
    private Integer Zonaid;

    @EJB
    private ZonaFacade zonaFacade;

    public zonaBean() {
        this.selectedZona = new Zona();
        this.zonas = new ArrayList<Zona>();
        int idzona;
    }

    public List<Zona> getZonas() {
        this.zonas = zonaFacade.findAll(); //Devuelve de la lista de todos los zonas
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public Integer getZonaid() {
        return Zonaid;
    }

    public void setZonaid(Integer Zonaid) {
        this.Zonaid = Zonaid;
    }

    public Zona getSelectedZona() {
        return selectedZona;
    }

    public void setSelectedZona(Zona selectedZona) {
        this.selectedZona = selectedZona;
    }

    public void EliminarZona(ActionEvent actionEvent) {
        Zona zona = zonaFacade.find(selectedZona.getId());
        String ms;
        if (zona.getId()>=0) {
            zonaFacade.remove(zona); 
            ms = "Se elimino correctamente el Zona";
        } else {    
            ms = "¡¡Este Zona es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarZona(ActionEvent actionEvent) {
        Zona zona = zonaFacade.find(selectedZona.getId()); 
        String ms;
        if (zona.getId()>= 0) {
            zona.setDescripcion(selectedZona.getDescripcion());
            zonaFacade.edit(zona); 
            ms = "Se modifico correctamente el Zona";
        } else {
            ms = "¡¡Este Zona es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearZona(ActionEvent actionEvent) {
        String ms;
        if (zonaFacade.ZonaUnico(selectedZona)) {
            Zona zona = new Zona(); 
            zona.setId(selectedZona.getId()); 
            zona.setDescripcion(selectedZona.getDescripcion());
            zonaFacade.create(zona); 
            ms = "Se creo correctamente el Zona";
        }else{
            ms = "Error al creal el Zona, el Zona ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Zona> getListaZonaes() {
        return zonaFacade.findAll();
    }
}