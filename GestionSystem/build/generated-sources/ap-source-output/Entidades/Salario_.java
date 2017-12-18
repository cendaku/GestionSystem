package Entidades;

import Entidades.SituacionLaboral;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Salario.class)
public class Salario_ { 

    public static volatile SingularAttribute<Salario, String> descripcion;
    public static volatile ListAttribute<Salario, SituacionLaboral> situacionLaboralList;
    public static volatile SingularAttribute<Salario, Integer> id;

}