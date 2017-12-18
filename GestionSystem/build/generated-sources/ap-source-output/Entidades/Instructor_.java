package Entidades;

import Entidades.ContratoInstructorcpi;
import Entidades.ContratoInstructorits;
import Entidades.Curso;
import Entidades.EstadoCivil;
import Entidades.Municipio;
import Entidades.NivelAcademico;
import Entidades.Sexo;
import Entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Instructor.class)
public class Instructor_ { 

    public static volatile SingularAttribute<Instructor, String> ruta;
    public static volatile SingularAttribute<Instructor, Integer> ci;
    public static volatile SingularAttribute<Instructor, Municipio> municipio;
    public static volatile SingularAttribute<Instructor, EstadoCivil> estadoCivil;
    public static volatile SingularAttribute<Instructor, String> nombre;
    public static volatile ListAttribute<Instructor, ContratoInstructorits> contratoInstructoritsList;
    public static volatile SingularAttribute<Instructor, String> apellido;
    public static volatile SingularAttribute<Instructor, Usuario> usuario;
    public static volatile SingularAttribute<Instructor, String> telefono;
    public static volatile ListAttribute<Instructor, ContratoInstructorcpi> contratoInstructorcpiList;
    public static volatile SingularAttribute<Instructor, NivelAcademico> nivelAcademico;
    public static volatile SingularAttribute<Instructor, Sexo> sexo;
    public static volatile SingularAttribute<Instructor, String> email;
    public static volatile ListAttribute<Instructor, Curso> cursoList;

}