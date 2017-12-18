/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.AlumnoFacade;
import Entidades.Alumno;
import Util.CargarArchivo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.event.ActionEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author administrador
 */
@Named(value = "alumnoBean")
@Dependent
public class alumnoBean {

    private List<Alumno> alumnos;
    private Alumno selectedAlumno;
    private UploadedFile archivo;
    private final String destino="/home/administrador/Imágenes/img/";
    private CargarArchivo cargarArchivo;
    @EJB
    AlumnoFacade alumnoFacade;

    /**
     * Creates a new instance of alumnoBean
     */
    public alumnoBean() {
        this.selectedAlumno = new Alumno();
        this.alumnos = new ArrayList<>();
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    public void EliminarAlumno(ActionEvent actionEvent) {
        alumnoFacade.remove(selectedAlumno);
    }

    public void ModificarAlumno(ActionEvent actionEvent) {
        String nombreArchivo;
        this.cargarArchivo = new CargarArchivo();
        if(!this.archivo.getFileName().isEmpty()){
           System.out.println("Cargamos el archivo");
           nombreArchivo=this.cargarArchivo.capturaArchivo(this.archivo,this.destino);
           this.selectedAlumno.setRuta(nombreArchivo);
            }
        alumnoFacade.edit(selectedAlumno);
    }

    public void CrearAlumno(ActionEvent actionEvent) {
        Alumno alumno = new Alumno();
        String nombreArchivo;
        this.cargarArchivo = new CargarArchivo();
        if(!this.archivo.getFileName().isEmpty()){
           System.out.println("Cargamos el archivo");
           nombreArchivo=this.cargarArchivo.capturaArchivo(this.archivo,this.destino);
           this.selectedAlumno.setRuta(nombreArchivo);
        }
        alumnoFacade.create(selectedAlumno);
    }
    
}
