package Entidades;

import Entidades.ContratoInstructorcpiPK;
import Entidades.Horario;
import Entidades.Instructor;
import Entidades.MateriaCpi;
import Entidades.PuntajeCpi;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(ContratoInstructorcpi.class)
public class ContratoInstructorcpi_ { 

    public static volatile SingularAttribute<ContratoInstructorcpi, ContratoInstructorcpiPK> contratoInstructorcpiPK;
    public static volatile SingularAttribute<ContratoInstructorcpi, String> pd;
    public static volatile ListAttribute<ContratoInstructorcpi, PuntajeCpi> puntajeCpiList;
    public static volatile SingularAttribute<ContratoInstructorcpi, MateriaCpi> materiaCpi;
    public static volatile SingularAttribute<ContratoInstructorcpi, Instructor> instructor1;
    public static volatile ListAttribute<ContratoInstructorcpi, Horario> horarioList;

}