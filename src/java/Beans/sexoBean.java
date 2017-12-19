package Beans;

import Dao.SexoFacade;
import Entidades.Sexo;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author administrador
 */
@Named(value = "sexoBean")
@RequestScoped
public class sexoBean {
    
    @EJB
    private SexoFacade sexoFacade;
    
    public sexoBean() {
    }
    
    public List<Sexo> getListasexoes() {
        return sexoFacade.findAll();
    }
    
}
