package Beans;

import Dao.AlumnoFacade;
import Dao.CertificadoFacade;
import Dao.CursoFacade;
import Dao.InscripcionFpaFacade;
import Entidades.Alumno;
import Entidades.Certificado;
import Entidades.Curso;
import Entidades.InscripcionFpa;
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
@Named(value = "CertificadoBean")
@ViewScoped
public class CertificadoBean implements Serializable{
 private List<Certificado> certificados;
 private Certificado selectedCertificado;
 private InscripcionFpa inscripcionFpa; 
 private Alumno alumno;
 private Curso curso;
 
 @EJB
 CertificadoFacade certificadoFacade;
 @EJB
 AlumnoFacade alumnoFacade;
 @EJB
 CursoFacade cursoFacade;
 @EJB
 InscripcionFpaFacade inscripcionFpaFacade; 
 
 public CertificadoBean(){
     this.certificados = new ArrayList();
     this.selectedCertificado = new Certificado();
     this.inscripcionFpa = new InscripcionFpa();
     this.alumno = new Alumno();
     this.curso = new Curso();
 }

    public List<Certificado> getCertificados() {
        this.certificados = certificadoFacade.findAll();
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public Certificado getSelectedCertificado() {
        return selectedCertificado;
    }

    public void setSelectedCertificado(Certificado selectedCertificado) {
        this.selectedCertificado = selectedCertificado;
    }

    public InscripcionFpa getInscripcionFpa() {
        return inscripcionFpa;
    }

    public void setInscripcionFpa(InscripcionFpa inscripcionFpa) {
        this.inscripcionFpa = inscripcionFpa;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CertificadoFacade getCertificadoFacade() {
        return certificadoFacade;
    }

    public void setCertificadoFacade(CertificadoFacade certificadoFacade) {
        this.certificadoFacade = certificadoFacade;
    }

    public AlumnoFacade getAlumnoFacade() {
        return alumnoFacade;
    }

    public void setAlumnoFacade(AlumnoFacade alumnoFacade) {
        this.alumnoFacade = alumnoFacade;
    }

    public CursoFacade getCursoFacade() {
        return cursoFacade;
    }

    public void setCursoFacade(CursoFacade cursoFacade) {
        this.cursoFacade = cursoFacade;
    }

    public InscripcionFpaFacade getInscripcionFpaFacade() {
        return inscripcionFpaFacade;
    }

    public void setInscripcionFpaFacade(InscripcionFpaFacade inscripcionFpaFacade) {
        this.inscripcionFpaFacade = inscripcionFpaFacade;
    }

 public void crearCertificado(ActionEvent actionEvent){
     Certificado certificado = new Certificado();
     
     certificado.setId(selectedCertificado.getId());
     certificado.setEntregado(selectedCertificado.getEntregado());
     certificado.setFechaRecibido(selectedCertificado.getFechaRecibido());
     certificado.setFechaEntregado(selectedCertificado.getFechaEntregado());
     certificado.setRetiradoPor(selectedCertificado.getRetiradoPor());
     
     
    }
}
