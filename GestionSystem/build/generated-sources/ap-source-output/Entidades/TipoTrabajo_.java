package Entidades;

import Entidades.SituacionLaboral;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(TipoTrabajo.class)
public class TipoTrabajo_ { 

    public static volatile SingularAttribute<TipoTrabajo, String> descripcion;
    public static volatile ListAttribute<TipoTrabajo, SituacionLaboral> situacionLaboralList;
    public static volatile SingularAttribute<TipoTrabajo, Integer> id;

}