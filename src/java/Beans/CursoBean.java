package Beans;

import Dao.CursoFacade;
import Dao.EspecialidadFacade;
import Dao.FrecuenciaDiariaFacade;
import Dao.InstructorFacade;
import Dao.LocalidadFacade;
import Dao.TipoFrecuenciaFacade;
import Entidades.Curso;
import Entidades.Especialidad;
import Entidades.FrecuenciaDiaria;
import Entidades.Instructor;
import Entidades.Localidad;
import Entidades.TipoFrecuencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author carolina
 */
@Named(value = "CursoBean")
@ViewScoped
public class CursoBean implements Serializable {
   private List<Curso> cursos;
   private Curso selectedCurso;
   private TipoFrecuencia tipoFrecuencia;
   private FrecuenciaDiaria frecuenciaDiaria;
   private Especialidad especialidad;
   private Localidad localidad;
   private Instructor instructor;
  
   
   @EJB
   CursoFacade cursoFacade;
   @EJB
   TipoFrecuenciaFacade tipoFrecuenciaFacade;
   @EJB
   FrecuenciaDiariaFacade frecuenciaDiariaFacade;
   @EJB
   EspecialidadFacade especialidadFacade;
   @EJB
   LocalidadFacade localidadFacade;
   @EJB
   InstructorFacade instructorFacade;
   
   public CursoBean(){
      this.cursos = new ArrayList();
      this.selectedCurso = new Curso();
      this.tipoFrecuencia = new TipoFrecuencia();
      this.frecuenciaDiaria = new FrecuenciaDiaria();
      this.especialidad = new Especialidad();
      this.localidad = new Localidad();
      this.instructor = new Instructor();
   }

    public List<Curso> getCursos() {
        this.cursos = cursoFacade.findAll();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso(Curso selectedCurso) {
        this.selectedCurso = selectedCurso;
    }

    public TipoFrecuencia getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setTipoFrecuencia(TipoFrecuencia tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }

    public FrecuenciaDiaria getFrecuenciaDiaria() {
        return frecuenciaDiaria;
    }

    public void setFrecuenciaDiaria(FrecuenciaDiaria frecuenciaDiaria) {
        this.frecuenciaDiaria = frecuenciaDiaria;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public CursoFacade getCursoFacade() {
        return cursoFacade;
    }

    public void setCursoFacade(CursoFacade cursoFacade) {
        this.cursoFacade = cursoFacade;
    }

    public TipoFrecuenciaFacade getTipoFrecuenciaFacade() {
        return tipoFrecuenciaFacade;
    }

    public void setTipoFrecuenciaFacade(TipoFrecuenciaFacade tipoFrecuenciaFacade) {
        this.tipoFrecuenciaFacade = tipoFrecuenciaFacade;
    }

    public FrecuenciaDiariaFacade getFrecuenciaDiariaFacade() {
        return frecuenciaDiariaFacade;
    }

    public void setFrecuenciaDiariaFacade(FrecuenciaDiariaFacade frecuenciaDiariaFacade) {
        this.frecuenciaDiariaFacade = frecuenciaDiariaFacade;
    }

    public EspecialidadFacade getEspecialidadFacade() {
        return especialidadFacade;
    }

    public void setEspecialidadFacade(EspecialidadFacade especialidadFacade) {
        this.especialidadFacade = especialidadFacade;
    }

    public LocalidadFacade getLocalidadFacade() {
        return localidadFacade;
    }

    public void setLocalidadFacade(LocalidadFacade localidadFacade) {
        this.localidadFacade = localidadFacade;
    }

    public InstructorFacade getInstructorFacade() {
        return instructorFacade;
    }

    public void setInstructorFacade(InstructorFacade instructorFacade) {
        this.instructorFacade = instructorFacade;
    }
   
   public void crearCurso(ActionEvent actionEvent){
      Curso curso = new Curso();
      
      curso.setNumeroNacional(selectedCurso.getNumeroNacional());
      curso.setNumeroRegional(selectedCurso.getNumeroRegional());
      curso.setHoraEntrada(selectedCurso.getHoraEntrada());
      curso.setHoraSalida(selectedCurso.getHoraSalida());
      curso.setFechaInicio(selectedCurso.getFechaInicio());
      curso.setFechaClausura(selectedCurso.getFechaClausura());
      curso.setActivo(selectedCurso.getActivo());
      
      tipoFrecuencia = tipoFrecuenciaFacade.find(tipoFrecuencia.getId());
      curso.setTipoFrecuencia(tipoFrecuencia);
      
      frecuenciaDiaria = frecuenciaDiariaFacade.find(frecuenciaDiaria.getId());
      curso.setFrecuenciaDiaria(frecuenciaDiaria);
      
      especialidad = especialidadFacade.find(especialidad.getId());
      curso.setEspecialidad(especialidad);
      
      localidad = localidadFacade.find(localidad.getId());
      curso.setLocalidad(localidad);
      
      instructor = instructorFacade.find(instructor.getCi());
      curso.setInstructor(instructor);
      
      
      cursoFacade.create(curso);
   }
   
   public void modificarCurso(ActionEvent actionEvent){
       this.selectedCurso.setTipoFrecuencia(tipoFrecuenciaFacade.find(tipoFrecuencia.getId()));
       this.selectedCurso.setFrecuenciaDiaria(frecuenciaDiariaFacade.find(frecuenciaDiaria.getId()));
       this.selectedCurso.setEspecialidad(especialidadFacade.find(especialidad.getId()));
       this.selectedCurso.setLocalidad(localidadFacade.find(localidad.getId()));
       this.selectedCurso.setInstructor(instructorFacade.find(instructor.getCi()));
       
       cursoFacade.edit(selectedCurso);
   }
   
   public void eliminarCurso(ActionEvent actionEvent){
       cursoFacade.remove(cursoFacade.find(selectedCurso.getNumeroNacional()));
   }
   
   public void seleccionarCurso(Integer id){
       this.selectedCurso=this.cursoFacade.find(id);
       this.tipoFrecuencia=this.selectedCurso.getTipoFrecuencia();
       this.frecuenciaDiaria=this.selectedCurso.getFrecuenciaDiaria();
       this.especialidad=this.selectedCurso.getEspecialidad();
       this.localidad=this.selectedCurso.getLocalidad();
       this.instructor=this.selectedCurso.getInstructor();
   }
}
