package Entidades;

import Entidades.SemestreHabilitado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Semestre.class)
public class Semestre_ { 

    public static volatile SingularAttribute<Semestre, String> descripcion;
    public static volatile SingularAttribute<Semestre, String> curso;
    public static volatile SingularAttribute<Semestre, Integer> id;
    public static volatile ListAttribute<Semestre, SemestreHabilitado> semestreHabilitadoList;

}