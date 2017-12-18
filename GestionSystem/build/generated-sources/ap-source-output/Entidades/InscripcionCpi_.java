package Entidades;

import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.InscripcionCpiPK;
import Entidades.PdCpi;
import Entidades.PuntajeCpi;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(InscripcionCpi.class)
public class InscripcionCpi_ { 

    public static volatile SingularAttribute<InscripcionCpi, PdCpi> pdCpi;
    public static volatile SingularAttribute<InscripcionCpi, Integer> puntajeTotal;
    public static volatile ListAttribute<InscripcionCpi, PuntajeCpi> puntajeCpiList;
    public static volatile SingularAttribute<InscripcionCpi, Alumno> alumno1;
    public static volatile SingularAttribute<InscripcionCpi, Carrera> alternativa2;
    public static volatile SingularAttribute<InscripcionCpi, Carrera> alternativa1;
    public static volatile SingularAttribute<InscripcionCpi, InscripcionCpiPK> inscripcionCpiPK;

}