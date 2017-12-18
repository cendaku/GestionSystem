package Entidades;

import Entidades.Carrera;
import Entidades.CarreraHabilitadaPK;
import Entidades.Grupo;
import Entidades.SemestreHabilitado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(CarreraHabilitada.class)
public class CarreraHabilitada_ { 

    public static volatile SingularAttribute<CarreraHabilitada, Carrera> carrera1;
    public static volatile SingularAttribute<CarreraHabilitada, CarreraHabilitadaPK> carreraHabilitadaPK;
    public static volatile SingularAttribute<CarreraHabilitada, Grupo> grupo1;
    public static volatile SingularAttribute<CarreraHabilitada, Integer> horaPasantia;
    public static volatile ListAttribute<CarreraHabilitada, SemestreHabilitado> semestreHabilitadoList;
    public static volatile SingularAttribute<CarreraHabilitada, Integer> cupo;

}