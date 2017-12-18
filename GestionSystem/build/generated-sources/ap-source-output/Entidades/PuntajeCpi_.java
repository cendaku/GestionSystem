package Entidades;

import Entidades.ContratoInstructorcpi;
import Entidades.InscripcionCpi;
import Entidades.PuntajeCpiPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(PuntajeCpi.class)
public class PuntajeCpi_ { 

    public static volatile SingularAttribute<PuntajeCpi, InscripcionCpi> inscripcionCpi;
    public static volatile SingularAttribute<PuntajeCpi, PuntajeCpiPK> puntajeCpiPK;
    public static volatile SingularAttribute<PuntajeCpi, ContratoInstructorcpi> contratoInstructorcpi;
    public static volatile SingularAttribute<PuntajeCpi, Integer> puntosAlcanzados;

}