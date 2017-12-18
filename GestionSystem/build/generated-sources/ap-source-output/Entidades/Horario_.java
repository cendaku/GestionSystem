package Entidades;

import Entidades.ContratoInstructorcpi;
import Entidades.HorarioInstructorits;
import Entidades.PdCpi;
import Entidades.SemestreHabilitado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile ListAttribute<Horario, HorarioInstructorits> horarioInstructoritsList;
    public static volatile ListAttribute<Horario, PdCpi> pdCpiList;
    public static volatile SingularAttribute<Horario, String> horarioFinal;
    public static volatile SingularAttribute<Horario, Integer> id;
    public static volatile ListAttribute<Horario, ContratoInstructorcpi> contratoInstructorcpiList;
    public static volatile SingularAttribute<Horario, String> dia;
    public static volatile SingularAttribute<Horario, String> horaInicio;
    public static volatile ListAttribute<Horario, SemestreHabilitado> semestreHabilitadoList;

}