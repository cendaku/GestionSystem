package Beans;

import Dao.NacionalidadFacade;
import Entidades.Nacionalidad;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author administrador
 */
@Named(value = "nacionalidadBean")
@RequestScoped
public class nacionalidadBean {

    @EJB
    private NacionalidadFacade nacionalidadFacade;
    
    public nacionalidadBean() {
    }
    
    public List<Nacionalidad> getListanacionalidades() {
        return nacionalidadFacade.findAll();
    }
    
}
