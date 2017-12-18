package Entidades;

import Entidades.Especialidad;
import Entidades.FrecuenciaDiaria;
import Entidades.InscripcionFpa;
import Entidades.Instructor;
import Entidades.Localidad;
import Entidades.TipoFrecuencia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, FrecuenciaDiaria> frecuenciaDiaria;
    public static volatile SingularAttribute<Curso, Instructor> instructor;
    public static volatile SingularAttribute<Curso, Date> fechaInicio;
    public static volatile ListAttribute<Curso, InscripcionFpa> inscripcionFpaList;
    public static volatile SingularAttribute<Curso, String> horaEntrada;
    public static volatile SingularAttribute<Curso, Date> fechaClausura;
    public static volatile SingularAttribute<Curso, String> numeroRegional;
    public static volatile SingularAttribute<Curso, Localidad> localidad;
    public static volatile SingularAttribute<Curso, Especialidad> especialidad;
    public static volatile SingularAttribute<Curso, TipoFrecuencia> tipoFrecuencia;
    public static volatile SingularAttribute<Curso, String> horaSalida;
    public static volatile SingularAttribute<Curso, Integer> numeroNacional;

}