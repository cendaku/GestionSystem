package Entidades;

import Entidades.Alumno;
import Entidades.AsistenciaFpa;
import Entidades.Certificado;
import Entidades.Curso;
import Entidades.InscripcionFpaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(InscripcionFpa.class)
public class InscripcionFpa_ { 

    public static volatile SingularAttribute<InscripcionFpa, Curso> curso1;
    public static volatile SingularAttribute<InscripcionFpa, InscripcionFpaPK> inscripcionFpaPK;
    public static volatile ListAttribute<InscripcionFpa, Certificado> certificadoList;
    public static volatile SingularAttribute<InscripcionFpa, Alumno> alumno1;
    public static volatile SingularAttribute<InscripcionFpa, String> culminado;
    public static volatile ListAttribute<InscripcionFpa, AsistenciaFpa> asistenciaFpaList;
    public static volatile SingularAttribute<InscripcionFpa, Date> fechaInscripcion;

}