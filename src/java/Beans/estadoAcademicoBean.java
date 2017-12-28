/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Dao.NivelAcademicoFacade;
import Dao.EstadoAcademicoFacade;
import Entidades.EstadoAcademico;
import Entidades.NivelAcademico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

@Named(value = "estadoAcademicoBean")
@RequestScoped
public class estadoAcademicoBean {

    private List<EstadoAcademico> estadoAcademicos;
    private EstadoAcademico selectedEstadoAcademico;
    private Integer NivelAcademicoid;   
    private List<Entidades.NivelAcademico> nivelAcademicos;
   


    @EJB
    EstadoAcademicoFacade estadoAcademicoFacade;
    @EJB
    NivelAcademicoFacade nivelAcademicoFacade;
    @EJB
    private EstadoAcademicoFacade estadoAcademicoEJB;

    public estadoAcademicoBean() {
        this.selectedEstadoAcademico = new EstadoAcademico();
        this.estadoAcademicos = new ArrayList<>();

    }

   @PostConstruct
   public void init() {
   this.nivelAcademicos = nivelAcademicoFacade.findAll();
   }

    public List<NivelAcademico> getNivelAcademicos() {
        return nivelAcademicos;
    }

    public void setNivelAcademicos(List<NivelAcademico> nivelAcademicos) {
        this.nivelAcademicos = nivelAcademicos;
    }

 
    
   
    public List<EstadoAcademico> getEstadoAcademicos() {
        this.estadoAcademicos = estadoAcademicoFacade.findAll();
        return estadoAcademicos;
    }

    public void setEstadoAcademicos(List<EstadoAcademico> estadoAcademicos) {
        this.estadoAcademicos = estadoAcademicos;
    }

    public Integer getNivelAcademicoid() {
        return NivelAcademicoid;
    }

    public void setNivelAcademicoid(Integer NivelAcademicoid) {
        this.NivelAcademicoid = NivelAcademicoid;
    }

    public EstadoAcademico getSelectedEstadoAcademico() {
        return selectedEstadoAcademico;
    }
    
    

    public void setSelectedEstadoAcademico(EstadoAcademico selectedEstadoAcademico) {
        this.selectedEstadoAcademico = selectedEstadoAcademico;
    }

    public void EliminarEstadoAcademico(ActionEvent actionEvent) {
        estadoAcademicoFacade.remove(estadoAcademicoFacade.find(selectedEstadoAcademico.getId()));
    
    }
    
    public void ModificarEstadoAcademico(ActionEvent actionEvent) {
        this.selectedEstadoAcademico.setNivelAcademico(this.nivelAcademicoFacade.find(this.NivelAcademicoid));
        estadoAcademicoFacade.edit(selectedEstadoAcademico);
    }

    public void CrearEstadoAcademico(ActionEvent actionEvent) {
        this.selectedEstadoAcademico.setNivelAcademico(this.nivelAcademicoFacade.find(this.NivelAcademicoid));
        estadoAcademicoFacade.create(selectedEstadoAcademico);
    }
    
    public void seleccionarEstadoAcademico(Integer id){
        this.selectedEstadoAcademico=this.estadoAcademicoFacade.find(id);
        this.NivelAcademicoid=this.selectedEstadoAcademico.getNivelAcademico().getId();
    }
}