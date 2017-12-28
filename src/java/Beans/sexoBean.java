package Beans;

import Dao.SexoFacade;
import Entidades.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


/**
 *
 * @author administrador
 */
@Named(value = "sexoBean")
@RequestScoped
public class sexoBean {
    
    private List<Sexo> sexos;
    private Sexo selectedSexo;
    private Integer Sexoid;

    @EJB
    private SexoFacade sexoFacade;
    
    public sexoBean() {
        this.selectedSexo = new Sexo();
        this.sexos = new ArrayList<Sexo>();
        int idsexo;
    }
    
    public List<Sexo> getListasexoes() {
        return sexoFacade.findAll();
    }
    
    public List<Sexo> getSexos() {
        this.sexos = sexoFacade.findAll(); //Devuelve de la lista de todos los sexos
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }

    public Integer getSexoid() {
        return Sexoid;
    }

    public void setSexoid(Integer Sexoid) {
        this.Sexoid = Sexoid;
    }

    public Sexo getSelectedSexo() {
        return selectedSexo;
    }

    public void setSelectedSexo(Sexo selectedSexo) {
        this.selectedSexo = selectedSexo;
    }

    public void EliminarSexo(ActionEvent actionEvent) {
        Sexo sexo = sexoFacade.find(selectedSexo.getId());
        String ms;
        if (sexo.getId()>= 0) {
            sexoFacade.remove(sexo); 
            ms = "Se elimino correctamente el Sexo";
        } else {    
            ms = "¡¡Este Sexo es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarSexo(ActionEvent actionEvent) {
        Sexo sexo = sexoFacade.find(selectedSexo.getId()); 
        String ms;
        if (sexo.getId()>=0) {
            sexo.setDescripcion(selectedSexo.getDescripcion());
            sexoFacade.edit(sexo); 
            ms = "Se modifico correctamente el Sexo";
        } else {
            ms = "¡¡Este Sexo es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearSexo(ActionEvent actionEvent) {
        String ms;
        if (sexoFacade.SexoUnico(selectedSexo)) {
            Sexo sexo = new Sexo(); 
            sexo.setId(selectedSexo.getId()); 
            sexo.setDescripcion(selectedSexo.getDescripcion());
            sexoFacade.create(sexo); 
            ms = "Se creo correctamente el Sexo";
        }else{
            ms = "Error al creal el Sexo, el Sexo ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Sexo> getListaSexoes() {
        return sexoFacade.findAll();
    }
    
}
