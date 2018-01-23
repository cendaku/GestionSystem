package Beans;

import Dao.EspecialidadFacade;
import Entidades.Especialidad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Toshiba
 */
@Named(value = "EspecialidadBean")
@RequestScoped
public class EspecialidadBean {
 private List<Especialidad> especialidades;
 private Especialidad selectedEspecialidad;
 @EJB
 EspecialidadFacade especialidadFacade;
 
 public EspecialidadBean(){
     this.especialidades = new ArrayList();
     this.selectedEspecialidad = new Especialidad();
 }

    public List<Especialidad> getEspecialidades() {
        this.especialidades = especialidadFacade.findAll();
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public Especialidad getSelectedEspecialidad() {
        return selectedEspecialidad;
    }

    public void setSelectedEspecialidad(Especialidad selectedEspecialidad) {
        this.selectedEspecialidad = selectedEspecialidad;
    }

    public EspecialidadFacade getEspecialidadFacade() {
        return especialidadFacade;
    }

    public void setEspecialidadFacade(EspecialidadFacade especialidadFacade) {
        this.especialidadFacade = especialidadFacade;
    }
 
 public void crearEspecialidad(ActionEvent actionEvent){
    Especialidad especialidad = new Especialidad();
    especialidad.setId(selectedEspecialidad.getId());
    especialidad.setDescripcion(selectedEspecialidad.getDescripcion());
    especialidadFacade.create(especialidad);
 }
 
 public void modificarEspecialidad(ActionEvent actionEvent){
     especialidadFacade.edit(selectedEspecialidad);
 }
 
 public void eliminarEspecialidad(ActionEvent actionEvent){
     especialidadFacade.remove(selectedEspecialidad);
 }
}
