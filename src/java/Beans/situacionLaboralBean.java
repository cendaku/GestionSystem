package Beans;

import Dao.SituacionLaboralFacade;
import Entidades.SituacionLaboral;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author administrador
 */
@Named(value = "situacionLaboralBean")
@RequestScoped
public class situacionLaboralBean {

    @EJB
    private SituacionLaboralFacade situacionLaboralFacade;
    
    public situacionLaboralBean() {
    }
    
    public List<SituacionLaboral> getListazonaes() {
        return situacionLaboralFacade.findAll();
    }
}
