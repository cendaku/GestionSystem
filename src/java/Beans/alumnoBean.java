package Beans;

import Dao.AlumnoFacade;
import Dao.DiscapacidadFacade;
import Dao.EstadoAcademicoFacade;
import Dao.EstadoCivilFacade;
import Dao.HorasTrabajoFacade;
import Dao.LocalidadFacade;
import Dao.MunicipioFacade;
import Dao.NacionalidadFacade;
import Dao.NivelAcademicoFacade;
import Dao.SalarioFacade;
import Dao.SexoFacade;
import Dao.UsuarioFacade;
import Dao.ZonaFacade;
import Entidades.Alumno;
import Entidades.Discapacidad;
import Entidades.EstadoAcademico;
import Entidades.HorasTrabajo;
import Entidades.Localidad;
import Entidades.Salario;
import Util.CargarArchivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author administrador
 */
@Named(value = "alumnoBean")
@ViewScoped
public class alumnoBean implements Serializable {

    private List<Alumno> alumnos;
    private Alumno selectedAlumno;
    private Integer sexoid;
    private Integer usuarioid;
    private Integer nacionalidadid;
    private Integer zonaid;
    private Integer estadoCivilid;
    private Integer localidadid;
    private Integer estadoAcademicoid;
    private Integer municipioid;
    private Integer nivelAcademicoid;
    private Integer salarioid;
    private Integer horasTrabajoid;
    private boolean checkedTrabaja;
    private boolean checkedNotrabaja;
    private boolean experiencia;
    private boolean tipoTrabajo;
    private List<String> discapacidad = new LinkedList<>();
    private final List<Localidad> lstLocalidads = new LinkedList<>();
    private final List<EstadoAcademico> lstEstadosAcademicos = new LinkedList<>();
    private List<Discapacidad> discapacidades = new LinkedList<>();

    public List<EstadoAcademico> getLstEstadosAcademicos() {
        return lstEstadosAcademicos;
    }

    public List<Localidad> getLstLocalidads() {
        return lstLocalidads;
    }

    private UploadedFile archivo;
    private final String destino = "/home/administrador/Imágenes/img/";
    private CargarArchivo cargarArchivo;

    @EJB
    AlumnoFacade alumnoFacade;
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
    @EJB
    NacionalidadFacade nacionalidadFacade;
    @EJB
    ZonaFacade zonaFacade;
    @EJB
    SalarioFacade salarioFacade;
    @EJB
    HorasTrabajoFacade horasTrabajoFacade;
    @EJB
    LocalidadFacade localidadFacade;
    @EJB
    DiscapacidadFacade EJBDiscapacidad;

    /**
     * Creates a new instance of alumnoBean
     */
    public alumnoBean() {
        this.selectedAlumno = new Alumno();
        this.alumnos = new ArrayList<>();
        this.discapacidad = new ArrayList<>();

    }

    public void init() {
        discapacidades = EJBDiscapacidad.findAll();

    }

    public List<Alumno> getAlumnos() {
        this.alumnos = alumnoFacade.findAll();
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Integer getSexoid() {
        return sexoid;
    }

    public void setSexoid(Integer sexoid) {
        this.sexoid = sexoid;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Integer getNacionalidadid() {
        return nacionalidadid;
    }

    public void setNacionalidadid(Integer nacionalidadid) {
        this.nacionalidadid = nacionalidadid;
    }

    public Integer getZonaid() {
        return zonaid;
    }

    public void setZonaid(Integer zonaid) {
        this.zonaid = zonaid;
    }

    public Integer getLocalidadid() {
        return localidadid;
    }

    public void setLocalidadid(Integer localidadid) {
        this.localidadid = localidadid;
    }

    public Integer getEstadoAcademicoid() {
        return estadoAcademicoid;
    }

    public void setEstadoAcademicoid(Integer estadoAcademicoid) {
        this.estadoAcademicoid = estadoAcademicoid;
    }

    public List<String> getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(List<String> discapacidad) {
        this.discapacidad = discapacidad;
    }

    public List<Discapacidad> getDiscapacidades() {
        return discapacidades;
    }

    public void setDiscapacidades(List<Discapacidad> discapacidades) {
        this.discapacidades = discapacidades;
    }

    public Integer getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Integer municipioid) {
        this.municipioid = municipioid;
    }

    public Integer getNivelAcademicoid() {
        return nivelAcademicoid;
    }

    public void setNivelAcademicoid(Integer NivelAcademicoid) {
        this.nivelAcademicoid = NivelAcademicoid;
    }

    public Integer getEstadoCivilid() {
        return estadoCivilid;
    }

    public void setEstadoCivilid(Integer estadoCivilid) {
        this.estadoCivilid = estadoCivilid;
    }

    public boolean isCheckedTrabaja() {
        return checkedTrabaja;
    }

    public void setCheckedTrabaja(boolean checkedTrabaja) {
        this.checkedTrabaja = checkedTrabaja;
    }

    public boolean isCheckedNotrabaja() {
        return checkedNotrabaja;
    }

    public void setCheckedNotrabaja(boolean checkedNotrabaja) {
        this.checkedNotrabaja = checkedNotrabaja;
    }

    public boolean isTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(boolean tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    public Integer getSalarioid() {
        return salarioid;
    }

    public void setSalarioid(Integer salarioid) {
        this.salarioid = salarioid;
    }

    public Integer getHorasTrabajoid() {
        return horasTrabajoid;
    }

    public void setHorasTrabajoid(Integer horasTrabajoid) {
        this.horasTrabajoid = horasTrabajoid;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public void EliminarAlumno(ActionEvent actionEvent) {
        alumnoFacade.remove(alumnoFacade.find(selectedAlumno.getCi()));
    }

    public void ModificarAlumno(ActionEvent actionEvent) {
        Alumno alumno = new Alumno();
        String nombreArchivo;
        this.cargarArchivo = new CargarArchivo();
        if (!this.archivo.getFileName().isEmpty()) {
            System.out.println("Cargamos la Imagen");
            nombreArchivo = this.cargarArchivo.capturaArchivo(this.archivo, this.destino);
            this.selectedAlumno.setRuta(nombreArchivo);
        }
        this.selectedAlumno.setEstadoCivil(this.estadoCivilFacade.find(this.estadoCivilid));
        this.selectedAlumno.setEstadoAcademico(this.estadoAcademicoFacade.find(this.estadoAcademicoid));
        this.selectedAlumno.setUsuario(this.UsuarioFacade.find(this.usuarioid));
        this.selectedAlumno.setSexo(this.sexoFacade.find(this.sexoid));
        this.selectedAlumno.setNacionalidad(this.nacionalidadFacade.find(this.nacionalidadid));
        this.selectedAlumno.setZona(this.zonaFacade.find(this.zonaid));
        this.selectedAlumno.setSalario(this.salarioFacade.find(this.salarioid));
        this.selectedAlumno.setHorasTrabajo(this.horasTrabajoFacade.find(this.horasTrabajoid));
        this.selectedAlumno.setLocalidad(this.localidadFacade.find(this.localidadid));
        alumnoFacade.edit(selectedAlumno);
    }

    public void CrearAlumno(ActionEvent actionEvent) {
        System.out.println("sexo: " + this.sexoid);
        Alumno alumno = new Alumno();
        this.selectedAlumno.setEstadoCivil(this.estadoCivilFacade.find(this.estadoCivilid));
        this.selectedAlumno.setEstadoAcademico(this.estadoAcademicoFacade.find(this.estadoAcademicoid));
        this.selectedAlumno.setUsuario(this.UsuarioFacade.find(this.usuarioid));
        this.selectedAlumno.setSexo(this.sexoFacade.find(this.sexoid));
        this.selectedAlumno.setNacionalidad(this.nacionalidadFacade.find(this.nacionalidadid));
        this.selectedAlumno.setZona(this.zonaFacade.find(this.zonaid));
        this.selectedAlumno.setSalario(this.salarioFacade.find(this.salarioid));
        this.selectedAlumno.setHorasTrabajo(this.horasTrabajoFacade.find(this.horasTrabajoid));
        this.selectedAlumno.setLocalidad(this.localidadFacade.find(this.localidadid));
        List<Discapacidad> lstDiscapSeleccionada=new LinkedList<>();
        for (String idD : this.discapacidad) {
            Discapacidad d = this.EJBDiscapacidad.find(Integer.parseInt(idD));
            lstDiscapSeleccionada.add(d);
        }
        this.selectedAlumno.setDiscapacidadList(lstDiscapSeleccionada);
        alumnoFacade.create(selectedAlumno);
    }

    public void seleccionarAlumno(Integer ci) {
        this.selectedAlumno = this.alumnoFacade.find(ci);
        this.sexoid = this.selectedAlumno.getSexo().getId();
        this.estadoCivilid = this.selectedAlumno.getEstadoCivil().getId();
        this.nacionalidadid = this.selectedAlumno.getNacionalidad().getId();
        this.zonaid = this.selectedAlumno.getZona().getId();
        this.salarioid = this.selectedAlumno.getSalario().getId();
        this.horasTrabajoid = this.selectedAlumno.getHorasTrabajo().getId();
        this.municipioid = this.selectedAlumno.getLocalidad().getMunicipio().getId();
        this.lstLocalidads.clear();
        this.lstLocalidads.addAll(this.localidadFacade.findByMunicipio(municipioid));
        this.nivelAcademicoid = this.selectedAlumno.getEstadoAcademico().getNivelAcademico().getId();
        this.lstEstadosAcademicos.clear();
        this.lstEstadosAcademicos.addAll(this.estadoAcademicoFacade.findByNivelAcademico(nivelAcademicoid));
        this.estadoAcademicoid = this.selectedAlumno.getEstadoAcademico().getId();
        this.localidadid = this.selectedAlumno.getLocalidad().getId();
        this.usuarioid = this.selectedAlumno.getUsuario().getCi();
        this.discapacidad.clear();
        for(Discapacidad d:this.selectedAlumno.getDiscapacidadList()){
            this.discapacidad.clear();
            this.discapacidad.add(d.getId().toString());
        }
    }

    public void filtroEstados() {
        this.lstEstadosAcademicos.clear();
        this.lstEstadosAcademicos.addAll(this.estadoAcademicoFacade.findByNivelAcademico(this.nivelAcademicoid));

    }

    public void cargarIdEstado() {
        System.out.println("id estado: " + this.estadoAcademicoid);
    }

    public void filtroLocalidads() {
        this.lstLocalidads.clear();
        this.lstLocalidads.addAll(this.localidadFacade.findByMunicipio(this.municipioid));
    }

    public void cargarIdLocalidad() {
        System.out.println("id localidad: " + this.localidadid);
    }

}