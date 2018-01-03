package Beans;

import Dao.EstadoCivilFacade;
import Dao.SexoFacade;
import Dao.InstructorFacade;
import Dao.MunicipioFacade;
import Dao.EstadoAcademicoFacade;
import Dao.NivelAcademicoFacade;
import Dao.UsuarioFacade;
import Entidades.EstadoAcademico;
import Entidades.Instructor;
import Util.CargarArchivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import Util.CargarArchivo;
import org.primefaces.model.UploadedFile;

@Named(value = "instructorBean")
@ViewScoped
public class instructorBean implements Serializable {

    private List<Instructor> Instructors;
    private Instructor selectedInstructor;
    private Integer sexoid;
    private Integer estadoAcademicoid;
    private Integer estadoCivilid;
    private Integer municipioid;
    private Integer usuarioid;
    private Integer nivelAcademicoid;
    private final List<EstadoAcademico> lstEstadosAcademicos = new LinkedList<>();
    private UploadedFile archivo;
    private final String destino = "/home/administrador/Imágenes/img/";
    private CargarArchivo cargarArchivo;

    public List<EstadoAcademico> getLstEstadosAcademicos() {
        return lstEstadosAcademicos;
    }

    @EJB
    InstructorFacade InstructorFacade;
    @EJB
    SexoFacade sexoFacade;
    @EJB
    EstadoAcademicoFacade estadoAcademicoFacade;
    @EJB
    EstadoCivilFacade estadoCivilFacade;
    @EJB
    MunicipioFacade municipioFacade;
    @EJB
    UsuarioFacade UsuarioFacade;
    @EJB
    NivelAcademicoFacade nivelAcademicoFacade;

    /* @EJB
    private InstructorFacade InstructorEJB;*/

    public instructorBean() {
        this.selectedInstructor = new Instructor();
        this.Instructors = new ArrayList<>();
    }

    public List<Instructor> getInstructors() {
        this.Instructors = InstructorFacade.findAll();
        return Instructors;
    }

    public void setInstructors(List<Instructor> Instructors) {
        this.Instructors = Instructors;
    }

    public Integer getSexoid() {
        return sexoid;
    }

    public void setSexoid(Integer Sexoid) {
        this.sexoid = Sexoid;
    }

    public Integer getEstadoAcademicoid() {
        return estadoAcademicoid;
    }

    public void setEstadoAcademicoid(Integer EstadoAcademicoid) {
        this.estadoAcademicoid = EstadoAcademicoid;
    }

    public Integer getEstadoCivilid() {
        return estadoCivilid;
    }

    public void setEstadoCivilid(Integer EstadoCivilid) {
        this.estadoCivilid = EstadoCivilid;
    }

    public Integer getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Integer Municipioid) {
        this.municipioid = Municipioid;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer Usuarioid) {
        this.usuarioid = Usuarioid;
    }

    public Integer getNivelAcademicoid() {
        return nivelAcademicoid;
    }

    public void setNivelAcademicoid(Integer NivelAcademicoid) {
        this.nivelAcademicoid = NivelAcademicoid;
    }

    public Instructor getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(Instructor selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public CargarArchivo getCargarArchivo() {
        return cargarArchivo;
    }

    public void setCargarArchivo(CargarArchivo cargarArchivo) {
        this.cargarArchivo = cargarArchivo;
    }

    public void EliminarInstructor(ActionEvent actionEvent) {
        InstructorFacade.remove(InstructorFacade.find(selectedInstructor.getCi()));
    }

    public void ModificarInstructor(ActionEvent actionEvent) {
        String nombreArchivo;
        this.cargarArchivo = new CargarArchivo();
        if (!this.archivo.getFileName().isEmpty()) {
            System.out.println("Cargamos la Imagen");
            nombreArchivo = this.cargarArchivo.capturaArchivo(this.archivo, this.destino);
            this.selectedInstructor.setRuta(nombreArchivo);
        }
        this.selectedInstructor.setEstadoCivil(this.estadoCivilFacade.find(this.estadoCivilid));
        this.selectedInstructor.setMunicipio(this.municipioFacade.find(this.municipioid));
        this.selectedInstructor.setEstadoAcademico(this.estadoAcademicoFacade.find(this.estadoAcademicoid));
        this.selectedInstructor.setUsuario(this.UsuarioFacade.find(this.usuarioid));
        this.selectedInstructor.setSexo(this.sexoFacade.find(this.sexoid));
        this.selectedInstructor.setEstadoAcademico(this.estadoAcademicoFacade.find(this.estadoAcademicoid));

        InstructorFacade.edit(selectedInstructor);
    }

    public void CrearInstructor(ActionEvent actionEvent) {
        String nombreArchivo;
        this.cargarArchivo = new CargarArchivo();
        if (!this.archivo.getFileName().isEmpty()) {
            System.out.println("Cargamos la Imagen");
            nombreArchivo = this.cargarArchivo.capturaArchivo(this.archivo, this.destino);
            this.selectedInstructor.setRuta(nombreArchivo);
        }
        this.selectedInstructor.setEstadoCivil(this.estadoCivilFacade.find(this.estadoCivilid));
        this.selectedInstructor.setMunicipio(this.municipioFacade.find(this.municipioid));
        this.selectedInstructor.setEstadoAcademico(this.estadoAcademicoFacade.find(this.estadoAcademicoid));
        this.selectedInstructor.setUsuario(this.UsuarioFacade.find(this.usuarioid));
        this.selectedInstructor.setSexo(this.sexoFacade.find(this.sexoid));
        InstructorFacade.create(selectedInstructor);
    }

    public void seleccionarInstructor(Integer ci) {
        this.selectedInstructor = this.InstructorFacade.find(ci);
        this.sexoid = this.selectedInstructor.getSexo().getId();
        this.estadoCivilid = this.selectedInstructor.getEstadoCivil().getId();
        this.municipioid = this.selectedInstructor.getMunicipio().getId();
        this.usuarioid = this.selectedInstructor.getUsuario().getCi();
        this.nivelAcademicoid = this.selectedInstructor.getEstadoAcademico().getNivelAcademico().getId();
        this.estadoAcademicoid = this.selectedInstructor.getEstadoAcademico().getId();
    }

    public void filtroEstados() {

        this.lstEstadosAcademicos.clear();
        this.lstEstadosAcademicos.addAll(this.estadoAcademicoFacade.findByNivelAcademico(this.nivelAcademicoid));
    }

    public void cargarIdEstado() {
        System.out.println("id estado: " + this.estadoAcademicoid);
    }

}
