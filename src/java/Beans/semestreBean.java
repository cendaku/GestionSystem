package Beans;

import Dao.SemestreFacade;
import Entidades.Semestre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "semestreBean")
@RequestScoped
public class semestreBean {

    private List<Semestre> semestres;
    private Semestre selectedSemestre;
    private Integer Semestreid;

    @EJB
    private SemestreFacade semestreFacade;

    public semestreBean() {
        this.selectedSemestre = new Semestre();
        this.semestres = new ArrayList<Semestre>();
        int idsemestre;
    }

    public List<Semestre> getSemestres() {
        this.semestres = semestreFacade.findAll(); //Devuelve de la lista de todos los semestres
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public Integer getSemestreid() {
        return Semestreid;
    }

    public void setSemestreid(Integer Semestreid) {
        this.Semestreid = Semestreid;
    }

    public Semestre getSelectedSemestre() {
        return selectedSemestre;
    }

    public void setSelectedSemestre(Semestre selectedSemestre) {
        this.selectedSemestre = selectedSemestre;
    }

    public void EliminarSemestre(ActionEvent actionEvent) {
         semestreFacade.remove(semestreFacade.find(selectedSemestre.getId()));
        
    }

    public void ModificarSemestre(ActionEvent actionEvent) {
        semestreFacade.edit(selectedSemestre);

    }

    public void CrearSemestre(ActionEvent actionEvent) {
    semestreFacade.create(selectedSemestre);
 
    }

    public List<Semestre> getListaSemestrees() {
        return semestreFacade.findAll();
    }
}
