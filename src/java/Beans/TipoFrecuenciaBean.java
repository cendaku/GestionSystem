package Beans;

import Dao.TipoFrecuenciaFacade;
import Entidades.TipoFrecuencia;
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
@Named(value = "TipoFrecuenciaBean")
@RequestScoped
public class TipoFrecuenciaBean {
  private List<TipoFrecuencia> tipofrecuencias;
  private TipoFrecuencia selectedTipoFrecuencia;
  @EJB
  TipoFrecuenciaFacade tipoFrecuenciaFacade;
  
  public TipoFrecuenciaBean(){
      this.tipofrecuencias = new ArrayList();
      this.selectedTipoFrecuencia = new TipoFrecuencia();
  }

    public List<TipoFrecuencia> getTipofrecuencias() {
        this.tipofrecuencias = tipoFrecuenciaFacade.findAll();
        return tipofrecuencias;
    }

    public void setTipofrecuencias(List<TipoFrecuencia> tipofrecuencias) {
        this.tipofrecuencias = tipofrecuencias;
    }

    public TipoFrecuencia getSelectedTipoFrecuencia() {
        return selectedTipoFrecuencia;
    }

    public void setSelectedTipoFrecuencia(TipoFrecuencia selectedTipoFrecuencia) {
        this.selectedTipoFrecuencia = selectedTipoFrecuencia;
    }

    public TipoFrecuenciaFacade getTipoFrecuenciaFacade() {
        return tipoFrecuenciaFacade;
    }

    public void setTipoFrecuenciaFacade(TipoFrecuenciaFacade tipoFrecuenciaFacade) {
        this.tipoFrecuenciaFacade = tipoFrecuenciaFacade;
    }
  
  public void crearTipoFrencuencia(ActionEvent actionEvent){
    TipoFrecuencia tipoFrecuencia = new TipoFrecuencia();
    tipoFrecuencia.setId(selectedTipoFrecuencia.getId());
    tipoFrecuencia.setDescripcion(selectedTipoFrecuencia.getDescripcion());
    tipoFrecuenciaFacade.create(tipoFrecuencia);
  }
  
  public void modificarTipoFrecuencia(ActionEvent actionEvent){
      tipoFrecuenciaFacade.edit(selectedTipoFrecuencia);
  }
  
  public void eliminarTipoFrecuencia(ActionEvent actionEvent){
      tipoFrecuenciaFacade.remove(selectedTipoFrecuencia);
  }
}

