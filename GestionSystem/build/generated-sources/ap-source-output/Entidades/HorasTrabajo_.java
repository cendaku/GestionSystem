package Entidades;

import Entidades.SituacionLaboral;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(HorasTrabajo.class)
public class HorasTrabajo_ { 

    public static volatile SingularAttribute<HorasTrabajo, String> descripcion;
    public static volatile ListAttribute<HorasTrabajo, SituacionLaboral> situacionLaboralList;
    public static volatile SingularAttribute<HorasTrabajo, Integer> id;

}