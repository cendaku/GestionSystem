package Entidades;

import Entidades.Alumno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Discapacidad.class)
public class Discapacidad_ { 

    public static volatile SingularAttribute<Discapacidad, String> descripcion;
    public static volatile ListAttribute<Discapacidad, Alumno> alumnoList;
    public static volatile SingularAttribute<Discapacidad, Integer> id;

}