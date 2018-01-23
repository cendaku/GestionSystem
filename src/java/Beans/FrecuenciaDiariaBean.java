package Beans;

import Dao.FrecuenciaDiariaFacade;
import Entidades.FrecuenciaDiaria;
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
@Named(value = "FrecuenciaDiariaBean")
@RequestScoped
public class FrecuenciaDiariaBean {
private List<FrecuenciaDiaria> frecuenciaDiarias;
private FrecuenciaDiaria selectedFrecuenciaDiaria;
@EJB
FrecuenciaDiariaFacade frecuenciaDiariaFacade;

public FrecuenciaDiariaBean(){
    this.frecuenciaDiarias = new ArrayList();
    this.selectedFrecuenciaDiaria = new FrecuenciaDiaria();
}

    public List<FrecuenciaDiaria> getFrecuenciaDiarias() {
        this.frecuenciaDiarias = frecuenciaDiariaFacade.findAll();
        return frecuenciaDiarias;
    }

    public void setFrecuenciaDiarias(List<FrecuenciaDiaria> frecuenciaDiarias) {
        this.frecuenciaDiarias = frecuenciaDiarias;
    }

    public FrecuenciaDiaria getSelectedFrecuenciaDiaria() {
        return selectedFrecuenciaDiaria;
    }

    public void setSelectedFrecuenciaDiaria(FrecuenciaDiaria selectedFrecuenciaDiaria) {
        this.selectedFrecuenciaDiaria = selectedFrecuenciaDiaria;
    }

    public FrecuenciaDiariaFacade getFrecuenciaDiariaFacade() {
        return frecuenciaDiariaFacade;
    }

    public void setFrecuenciaDiariaFacade(FrecuenciaDiariaFacade frecuenciaDiariaFacade) {
        this.frecuenciaDiariaFacade = frecuenciaDiariaFacade;
    }

public void crearFrecuenciaDiaria(ActionEvent actionEvent){
  FrecuenciaDiaria frecuenciaDiaria = new FrecuenciaDiaria();
  frecuenciaDiaria.setId(selectedFrecuenciaDiaria.getId());
  frecuenciaDiaria.setDescripcion(selectedFrecuenciaDiaria.getDescripcion());
  frecuenciaDiariaFacade.create(frecuenciaDiaria);
}

public void modificarFrecuenciaDiaria(ActionEvent actionEvent){
    frecuenciaDiariaFacade.edit(selectedFrecuenciaDiaria);
}

public void eliminarFrecuenciaDiaria(ActionEvent actionEvent){
    frecuenciaDiariaFacade.remove(selectedFrecuenciaDiaria);
}
}
