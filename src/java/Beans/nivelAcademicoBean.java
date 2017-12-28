/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.NivelAcademicoFacade;
import Entidades.NivelAcademico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "nivelAcademicoBean")
@RequestScoped
public class nivelAcademicoBean {

    private List<NivelAcademico> nivelAcademicos;
    private NivelAcademico selectedNivelAcademico;
    private Integer NivelAcademicoid;

    @EJB
    private NivelAcademicoFacade nivelAcademicoFacade;

    public nivelAcademicoBean() {
        this.selectedNivelAcademico = new NivelAcademico();
        this.nivelAcademicos = new ArrayList<NivelAcademico>();
        int idnivelAcademico;
    }

    public List<NivelAcademico> getNivelAcademicos() {
        this.nivelAcademicos = nivelAcademicoFacade.findAll(); //Devuelve de la lista de todos los nivelAcademicos
        return nivelAcademicos;
    }

    public void setNivelAcademicos(List<NivelAcademico> nivelAcademicos) {
        this.nivelAcademicos = nivelAcademicos;
    }

    public Integer getNivelAcademicoid() {
        return NivelAcademicoid;
    }

    public void setNivelAcademicoid(Integer NivelAcademicoid) {
        this.NivelAcademicoid = NivelAcademicoid;
    }

    public NivelAcademico getSelectedNivelAcademico() {
        return selectedNivelAcademico;
    }

    public void setSelectedNivelAcademico(NivelAcademico selectedNivelAcademico) {
        this.selectedNivelAcademico = selectedNivelAcademico;
    }

    public void EliminarNivelAcademico(ActionEvent actionEvent) {
        NivelAcademico nivelAcademico = nivelAcademicoFacade.find(selectedNivelAcademico.getId());
        String ms;
        if (nivelAcademico.getId()>= 0) {
            nivelAcademicoFacade.remove(nivelAcademico); 
            ms = "Se elimino correctamente el Nivel Academico";
        } else {    
            ms = "¡¡Este Nivel Academico es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarNivelAcademico(ActionEvent actionEvent) {
        NivelAcademico nivelAcademico = nivelAcademicoFacade.find(selectedNivelAcademico.getId()); 
        String ms;
        if (nivelAcademico.getId()>= 0) {
            nivelAcademico.setDescripcion(selectedNivelAcademico.getDescripcion());
            nivelAcademicoFacade.edit(nivelAcademico); 
            ms = "Se modifico correctamente el Nivel Academico";
        } else {
            ms = "¡¡Este Nivel Academico es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearNivelAcademico(ActionEvent actionEvent) {
        String ms;
        if (nivelAcademicoFacade.NivelAcademicoUnico(selectedNivelAcademico)) {
            NivelAcademico nivelAcademico = new NivelAcademico(); 
            nivelAcademico.setId(selectedNivelAcademico.getId()); 
            nivelAcademico.setDescripcion(selectedNivelAcademico.getDescripcion());
            nivelAcademicoFacade.create(nivelAcademico); 
            ms = "Se creo correctamente el Nivel Academico";
        }else{
            ms = "Error al creal el Nivel Academico, el Nivel Academico ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<NivelAcademico> getListaNivelAcademicoes() {
        return nivelAcademicoFacade.findAll();
    }
}
