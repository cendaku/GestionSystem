package Beans;

import Dao.ZonaFacade;
import Entidades.Zona;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author administrador
 */
@Named(value = "zonaBean")
@RequestScoped
public class zonaBean {

    @EJB
    private ZonaFacade zonaFacade;
    public zonaBean() {
    }
    
    public List<Zona> getListazonaes() {
        return zonaFacade.findAll();
    }
    
}
