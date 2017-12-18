package Entidades;

import Entidades.CarreraHabilitada;
import Entidades.Horario;
import Entidades.InscripcionIts;
import Entidades.MateriaIts;
import Entidades.Semestre;
import Entidades.SemestreHabilitadoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(SemestreHabilitado.class)
public class SemestreHabilitado_ { 

    public static volatile ListAttribute<SemestreHabilitado, InscripcionIts> inscripcionItsList;
    public static volatile SingularAttribute<SemestreHabilitado, Semestre> semestre1;
    public static volatile SingularAttribute<SemestreHabilitado, SemestreHabilitadoPK> semestreHabilitadoPK;
    public static volatile SingularAttribute<SemestreHabilitado, Integer> materiasTotalHoras;
    public static volatile ListAttribute<SemestreHabilitado, MateriaIts> materiaItsList;
    public static volatile SingularAttribute<SemestreHabilitado, CarreraHabilitada> carreraHabilitada;
    public static volatile ListAttribute<SemestreHabilitado, Horario> horarioList;

}