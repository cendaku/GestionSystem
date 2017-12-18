package Beans;

import Dao.RolFacade;
import Entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author satte
 */
@Named(value = "rolBean")
@RequestScoped
public class rolBean {

    private List<Rol> rols;
    private Rol selectedRol;
    private Integer Rolid;

    @EJB
    private RolFacade rolFacade;

    public rolBean() {
        this.selectedRol = new Rol();
        this.rols = new ArrayList<Rol>();
        int idrol;
    }

    public List<Rol> getRols() {
        this.rols = rolFacade.findAll();
        return rols;
    }

    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }

    public Integer getRolid() {
        return Rolid;
    }

    public void setRolid(Integer Rolid) {
        this.Rolid = Rolid;
    }

    public Rol getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(Rol selectedRol) {
        this.selectedRol = selectedRol;
    }

    public void EliminarRol(ActionEvent actionEvent) {
        Rol rol = rolFacade.find(selectedRol.getId());
        String ms;
        if (rol.getId()> 4) {
            rolFacade.remove(rol); 
            ms = "Se elimino correctamente el Rol";
        } else {    
            ms = "¡¡Este Rol es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarRol(ActionEvent actionEvent) {
        Rol rol = rolFacade.find(selectedRol.getId()); 
        String ms;
        if (rol.getId()> 4) {
            rol.setDescripcion(selectedRol.getDescripcion());
            rol.setInstitucion(selectedRol.getInstitucion());
            rolFacade.edit(rol); 
            ms = "Se modifico correctamente el Rol";
        } else {
            ms = "¡¡Este Rol es fijo no se puede modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearRol(ActionEvent actionEvent) {
        String ms;
        if (rolFacade.RolUnico(selectedRol)) {
            Rol rol = new Rol(); 
            rol.setId(selectedRol.getId()); 
            rol.setDescripcion(selectedRol.getDescripcion());
            rol.setInstitucion(selectedRol.getInstitucion());
            rolFacade.create(rol); 
            ms = "Se creo correctamente el Rol";
        }else{
            ms = "Error al creal el Rol, el Rol ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Rol> getListaRoles() {
        return rolFacade.findAll();
    }
}
