package Beans;

import Dao.CarreraFacade;
import Entidades.Carrera;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "carreraBean")
@RequestScoped
public class carreraBean {

    private List<Carrera> carreras;
    private Carrera selectedCarrera;
    private Integer Carreraid;

    @EJB
    private CarreraFacade carreraFacade;

    public carreraBean() {
        this.selectedCarrera = new Carrera();
        this.carreras = new ArrayList<Carrera>();
        int idcarrera;
    }

    public List<Carrera> getCarreras() {
        this.carreras = carreraFacade.findAll(); //Devuelve de la lista de todos los carreras
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Integer getCarreraid() {
        return Carreraid;
    }

    public void setCarreraid(Integer Carreraid) {
        this.Carreraid = Carreraid;
    }

    public Carrera getSelectedCarrera() {
        return selectedCarrera;
    }

    public void setSelectedCarrera(Carrera selectedCarrera) {
        this.selectedCarrera = selectedCarrera;
    }

    public void EliminarCarrera(ActionEvent actionEvent) {
         carreraFacade.remove(carreraFacade.find(selectedCarrera.getId()));
        
    }

    public void ModificarCarrera(ActionEvent actionEvent) {
        carreraFacade.edit(selectedCarrera);

    }

    public void CrearCarrera(ActionEvent actionEvent) {
    carreraFacade.create(selectedCarrera);
 
    }

    public List<Carrera> getListaCarreraes() {
        return carreraFacade.findAll();
    }
}
