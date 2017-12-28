package Beans;

import Dao.SalarioFacade;
import Entidades.Salario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "salarioBean")
@RequestScoped
public class salarioBean {

    private List<Salario> salarios;
    private Salario selectedSalario;
    private Integer Salarioid;

    @EJB
    private SalarioFacade salarioFacade;

    public salarioBean() {
        this.selectedSalario = new Salario();
        this.salarios = new ArrayList<Salario>();
        int idsalario;
    }

    public List<Salario> getSalarios() {
        this.salarios = salarioFacade.findAll(); //Devuelve de la lista de todos los salarios
        return salarios;
    }

    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
    }

    public Integer getSalarioid() {
        return Salarioid;
    }

    public void setSalarioid(Integer Salarioid) {
        this.Salarioid = Salarioid;
    }

    public Salario getSelectedSalario() {
        return selectedSalario;
    }

    public void setSelectedSalario(Salario selectedSalario) {
        this.selectedSalario = selectedSalario;
    }

    public void EliminarSalario(ActionEvent actionEvent) {
        Salario salario = salarioFacade.find(selectedSalario.getId());
        String ms;
        if (salario.getId()>= 0) {
            salarioFacade.remove(salario); 
            ms = "Se elimino correctamente el Salario";
        } else {    
            ms = "¡¡Este Salario es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarSalario(ActionEvent actionEvent) {
        Salario salario = salarioFacade.find(selectedSalario.getId()); 
        String ms;
        if (salario.getId()>= 0) {
            salario.setDescripcion(selectedSalario.getDescripcion());
            salarioFacade.edit(salario); 
            ms = "Se modifico correctamente el Salario";
        } else {
            ms = "¡¡Este Salario es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearSalario(ActionEvent actionEvent) {
        String ms;
        if (salarioFacade.SalarioUnico(selectedSalario)) {
            Salario salario = new Salario(); 
            salario.setId(selectedSalario.getId()); 
            salario.setDescripcion(selectedSalario.getDescripcion());
            salarioFacade.create(salario); 
            ms = "Se creo correctamente el Salario";
        }else{
            ms = "Error al creal el Salario, el Salario ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Salario> getListaSalarioes() {
        return salarioFacade.findAll();
    }
}
