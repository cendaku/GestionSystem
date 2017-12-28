package Beans;


import Dao.MunicipioFacade;
import Entidades.Municipio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "municipioBean")
@RequestScoped
public class municipioBean {

    private List<Municipio> municipios;
    private Municipio selectedMunicipio;
    private Integer Municipioid;
    private List<Municipio> selectOneItemsMunicipio;

    @EJB
    private MunicipioFacade municipioFacade;

    public municipioBean() {
        this.selectedMunicipio = new Municipio();
        //int idmunicipio;
    }
    
    @PostConstruct
    public void init(){
        this.municipios = municipioFacade.findAll();
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

   
    
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Integer getMunicipioid() {
        return Municipioid;
    }

    public void setMunicipioid(Integer Municipioid) {
        this.Municipioid = Municipioid;
    }

    public Municipio getSelectedMunicipio() {
        return selectedMunicipio;
    }

    public void setSelectedMunicipio(Municipio selectedMunicipio) {
        this.selectedMunicipio = selectedMunicipio;
    }
    

    public void EliminarMunicipio(ActionEvent actionEvent) {
        Municipio municipio = municipioFacade.find(selectedMunicipio.getId());
        String ms;
        if (municipio.getId()>= 0) {
            municipioFacade.remove(municipio); 
            ms = "Se elimino correctamente el Municipio";
        } else {    
            ms = "¡¡Este Municipio es fijo no se puede eliminar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ModificarMunicipio(ActionEvent actionEvent) {
        Municipio municipio = municipioFacade.find(selectedMunicipio.getId()); 
        String ms;
        if (municipio.getId()>= 0) {
            municipio.setDescripcion(selectedMunicipio.getDescripcion());
            municipioFacade.edit(municipio); 
            ms = "Se modifico correctamente el Municipio";
        } else {
            ms = "¡¡Este Municipio es fijo no se modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearMunicipio(ActionEvent actionEvent) {
        String ms;
        if (municipioFacade.MunicipioUnico(selectedMunicipio)) {
            Municipio municipio = new Municipio(); 
            municipio.setId(selectedMunicipio.getId()); 
            municipio.setDescripcion(selectedMunicipio.getDescripcion());
            municipioFacade.create(municipio); 
            ms = "Se creo correctamente el Municipio";
        }else{
            ms = "Error al creal el Municipio, el Municipio ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}