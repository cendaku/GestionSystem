package Entidades;

import Entidades.Discapacidad;
import Entidades.EstadoCivil;
import Entidades.InscripcionCpi;
import Entidades.InscripcionFpa;
import Entidades.InscripcionIts;
import Entidades.Localidad;
import Entidades.Nacionalidad;
import Entidades.NivelAcademico;
import Entidades.Sexo;
import Entidades.SituacionLaboral;
import Entidades.Usuario;
import Entidades.Zona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile ListAttribute<Alumno, InscripcionIts> inscripcionItsList;
    public static volatile SingularAttribute<Alumno, SituacionLaboral> situacionLaboral;
    public static volatile SingularAttribute<Alumno, String> fechaNacimiento;
    public static volatile SingularAttribute<Alumno, String> ruta;
    public static volatile SingularAttribute<Alumno, Integer> ci;
    public static volatile ListAttribute<Alumno, Discapacidad> discapacidadList;
    public static volatile ListAttribute<Alumno, InscripcionCpi> inscripcionCpiList;
    public static volatile SingularAttribute<Alumno, String> direccion;
    public static volatile SingularAttribute<Alumno, EstadoCivil> estadoCivil;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, Nacionalidad> nacionalidad;
    public static volatile SingularAttribute<Alumno, String> nombreContacto;
    public static volatile SingularAttribute<Alumno, Zona> zona;
    public static volatile ListAttribute<Alumno, InscripcionFpa> inscripcionFpaList;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile SingularAttribute<Alumno, String> celular;
    public static volatile SingularAttribute<Alumno, Localidad> localidad;
    public static volatile SingularAttribute<Alumno, Usuario> usuario;
    public static volatile SingularAttribute<Alumno, String> telefono;
    public static volatile SingularAttribute<Alumno, String> telefonoContacto;
    public static volatile SingularAttribute<Alumno, NivelAcademico> nivelAcademico;
    public static volatile SingularAttribute<Alumno, Sexo> sexo;
    public static volatile SingularAttribute<Alumno, String> email;

}