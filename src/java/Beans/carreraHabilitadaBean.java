/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.CarreraFacade;
import Dao.CarreraHabilitadaFacade;
import Dao.GrupoFacade;
import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.CarreraHabilitada;
import Entidades.CarreraHabilitadaPK;

import Entidades.Grupo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.ws.Action;


/**
 *
 * @author satte
 */
@Named(value = "carreraHabilitadaBean")
@RequestScoped
public class carreraHabilitadaBean {


    private List<CarreraHabilitada> carreraHabilitada;
    private Grupo grupo;
    private Alumno alumno;
    private Carrera carrera;
    @EJB
    GrupoFacade EJBGrupo;

    @EJB
    CarreraHabilitadaFacade EJBCarreraGrupo;
    @EJB
    CarreraFacade EJBCarrera;

    public carreraHabilitadaBean() {
        this.alumno = new Alumno();
        this.carrera = new Carrera();
        this.grupo = new Grupo();
    }





    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void crearcarreraHabilitada(Action event)  {
        try {

           

            CarreraHabilitadaPK id = new CarreraHabilitadaPK();
            id.setCarrera(this.carrera.getId());
            id.setGrupo(this.grupo.getId());

            CarreraHabilitada carrera2 = new CarreraHabilitada();
            carrera2.setCarrera1(EJBCarrera.find(this.carrera.getId()));
            carrera2.setGrupo1(grupo);
            carrera2.setCarreraHabilitadaPK(id);
         
            EJBCarreraGrupo.create(carrera2);
            System.out.println("Se agrego la carrera");
        } catch (Exception e) {
        }
    }



    public void setCarreraHabilitada(List<CarreraHabilitada> carreraHabilitada) {
        this.carreraHabilitada = carreraHabilitada;
    }

    public void eliminarcarreraHabilitada(Action event)  {
        try {

            CarreraHabilitadaPK id = new CarreraHabilitadaPK();
            id.setCarrera(this.carrera.getId());
            id.setGrupo(this.grupo.getId());
           

            CarreraHabilitada carrera2 = new CarreraHabilitada();
            carrera2.setCarrera1(EJBCarrera.find(this.carrera.getId()));
            carrera2.setGrupo1(grupo);
            carrera2.setCarreraHabilitadaPK(id);

            EJBCarreraGrupo.remove(carrera2);
            System.out.println("Se elimino la carrera");
        } catch (Exception e) {
            System.out.println("No se elimino correctamente");
        }
    }
}
