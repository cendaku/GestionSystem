package Entidades;

import Entidades.Alumno;
import Entidades.AsistenciaIts;
import Entidades.InscripcionItsPK;
import Entidades.Notasits;
import Entidades.SemestreHabilitado;
import Entidades.TrabajoPracticoits;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(InscripcionIts.class)
public class InscripcionIts_ { 

    public static volatile SingularAttribute<InscripcionIts, InscripcionItsPK> inscripcionItsPK;
    public static volatile SingularAttribute<InscripcionIts, SemestreHabilitado> semestreHabilitado;
    public static volatile ListAttribute<InscripcionIts, AsistenciaIts> asistenciaItsList;
    public static volatile ListAttribute<InscripcionIts, Notasits> notasitsList;
    public static volatile SingularAttribute<InscripcionIts, Alumno> alumno1;
    public static volatile ListAttribute<InscripcionIts, TrabajoPracticoits> trabajoPracticoitsList;

}