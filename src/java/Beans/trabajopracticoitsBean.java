package Beans;

import Dao.TrabajoPracticoitsFacade;
import Entidades.TrabajoPracticoits;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author administrador
 */
@Named(value = "trabajopracticoitsBean")
@ViewScoped
public class trabajopracticoitsBean implements Serializable {

    private List<TrabajoPracticoits> TrabajoPracticoitss;
    private TrabajoPracticoits selectedTrabajoPracticoits;
    private Integer puntajetotal;
    private Integer instructor;
    private Integer materia_its;
    private Integer alumno;
    private Integer sem_habi_num;
    private Integer sem_habi_anho;
    private Integer grupo;
    private Integer carrera;
    private Integer semestre;

    @EJB
    private TrabajoPracticoitsFacade trabajoPracticoitsFacade;

    /**
     * Creates a new instance of trabajopracticoitsBean
     */
    public trabajopracticoitsBean() {
        this.selectedTrabajoPracticoits = new TrabajoPracticoits();
        this.TrabajoPracticoitss = new ArrayList<TrabajoPracticoits>();
    }

    public List<TrabajoPracticoits> getTrabajoPracticoitss() {
        return TrabajoPracticoitss;
    }

    public void setTrabajoPracticoitss(List<TrabajoPracticoits> TrabajoPracticoitss) {
        this.TrabajoPracticoitss = TrabajoPracticoitss;
    }

    public TrabajoPracticoits getSelectedTrabajoPracticoits() {
        return selectedTrabajoPracticoits;
    }

    public void setSelectedTrabajoPracticoits(TrabajoPracticoits selectedTrabajoPracticoits) {
        this.selectedTrabajoPracticoits = selectedTrabajoPracticoits;
    }

    public Integer getPuntajetotal() {
        return puntajetotal;
    }

    public void setPuntajetotal(Integer puntajetotal) {
        this.puntajetotal = puntajetotal;
    }

    public Integer getInstructor() {
        return instructor;
    }

    public void setInstructor(Integer instructor) {
        this.instructor = instructor;
    }

    public Integer getMateria_its() {
        return materia_its;
    }

    public void setMateria_its(Integer materia_its) {
        this.materia_its = materia_its;
    }

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getSem_habi_num() {
        return sem_habi_num;
    }

    public void setSem_habi_num(Integer sem_habi_num) {
        this.sem_habi_num = sem_habi_num;
    }

    public Integer getSem_habi_anho() {
        return sem_habi_anho;
    }

    public void setSem_habi_anho(Integer sem_habi_anho) {
        this.sem_habi_anho = sem_habi_anho;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Integer getCarrera() {
        return carrera;
    }

    public void setCarrera(Integer carrera) {
        this.carrera = carrera;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public TrabajoPracticoitsFacade getTrabajoPracticoitsFacade() {
        return trabajoPracticoitsFacade;
    }

    public void setTrabajoPracticoitsFacade(TrabajoPracticoitsFacade trabajoPracticoitsFacade) {
        this.trabajoPracticoitsFacade = trabajoPracticoitsFacade;
    }
    
    public void EliminarTrabajoPrac(ActionEvent actionEvent) {
        trabajoPracticoitsFacade.remove(trabajoPracticoitsFacade.find(selectedTrabajoPracticoits));
    }
    
    public void ModificarTrabajoPrac(ActionEvent actionEvent) {
        trabajoPracticoitsFacade.edit(trabajoPracticoitsFacade.find(selectedTrabajoPracticoits));
    }
    
    public void CrearTrabajoPrac(ActionEvent actionEvent) {
        trabajoPracticoitsFacade.create(trabajoPracticoitsFacade.find(selectedTrabajoPracticoits));
    }

}
