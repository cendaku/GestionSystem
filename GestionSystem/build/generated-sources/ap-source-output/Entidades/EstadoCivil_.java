package Entidades;

import Entidades.Alumno;
import Entidades.Instructor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(EstadoCivil.class)
public class EstadoCivil_ { 

    public static volatile SingularAttribute<EstadoCivil, String> descripcion;
    public static volatile ListAttribute<EstadoCivil, Instructor> instructorList;
    public static volatile ListAttribute<EstadoCivil, Alumno> alumnoList;
    public static volatile SingularAttribute<EstadoCivil, Integer> id;

}