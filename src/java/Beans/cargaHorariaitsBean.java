
package Beans;

import Dao.CargaHorariaitsFacade;
import Entidades.CargaHorariaits;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.ws.Action;

/**
 *
 * @author satte
 */
@Named(value = "cargaHorariaitsBean")
@RequestScoped
public class cargaHorariaitsBean {

    private List<CargaHorariaits> cargaHorariaitss;
    private CargaHorariaits selectedCargaHorariaits;
    @EJB
    CargaHorariaitsFacade cargaHorariaitsFacade;

    public cargaHorariaitsBean() {
        this.cargaHorariaitss = new ArrayList<>();
        this.selectedCargaHorariaits = new CargaHorariaits();
    }

    public List<CargaHorariaits> getCargaHorariaitss() {
        return cargaHorariaitsFacade.findAll();
    }

    public void setCargaHorariaitss(List<CargaHorariaits> cargaHorariaitss) {
        this.cargaHorariaitss = cargaHorariaitss;
    }

    public CargaHorariaits getSelectedCargaHorariaits() {
        return selectedCargaHorariaits;
    }

    public void setSelectedCargaHorariaits(CargaHorariaits selectedCargaHorariaits) {
        this.selectedCargaHorariaits = selectedCargaHorariaits;
    }

    public void modificarCargaHorariaits(Action event) {
        cargaHorariaitsFacade.edit(selectedCargaHorariaits);
    }

    public void crearCargaHorariaits(Action event) {
        
        cargaHorariaitsFacade.create(selectedCargaHorariaits);
    }

    public void eliminarCargaHorariaits(Action event) {
        cargaHorariaitsFacade.remove(selectedCargaHorariaits);
    }
}
