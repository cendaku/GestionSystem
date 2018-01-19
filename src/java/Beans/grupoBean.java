package Beans;

import Dao.GrupoFacade;
import Entidades.Grupo;
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
@Named(value = "grupoBean")
@RequestScoped
public class grupoBean {

    private List<Grupo> grupos;
    private Grupo selectedGrupo;
    @EJB
    GrupoFacade grupoFacade;

    public grupoBean() {
        this.grupos = new ArrayList<>();
        this.selectedGrupo = new Grupo();
    }

    public List<Grupo> getGrupos() {
        return grupoFacade.findAll();
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Grupo getSelectedGrupo() {
        return selectedGrupo;
    }

    public void setSelectedGrupo(Grupo selectedGrupo) {
        this.selectedGrupo = selectedGrupo;
    }

    public void modificarGrupo(Action event) {
        grupoFacade.edit(selectedGrupo);
    }

    public void crearGrupo(Action event) {
        grupoFacade.create(selectedGrupo);
    }

    public void eliminarGrupo(Action event) {
        grupoFacade.remove(selectedGrupo);
    }
}
