package Entidades;

import Entidades.Instructor;
import Entidades.Localidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> descripcion;
    public static volatile ListAttribute<Municipio, Localidad> localidadList;
    public static volatile ListAttribute<Municipio, Instructor> instructorList;
    public static volatile SingularAttribute<Municipio, Integer> id;

}