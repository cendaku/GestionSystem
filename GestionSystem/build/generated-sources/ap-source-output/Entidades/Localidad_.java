package Entidades;

import Entidades.Alumno;
import Entidades.Curso;
import Entidades.LocalidadPK;
import Entidades.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Localidad.class)
public class Localidad_ { 

    public static volatile SingularAttribute<Localidad, String> descripcion;
    public static volatile SingularAttribute<Localidad, Municipio> municipio1;
    public static volatile ListAttribute<Localidad, Alumno> alumnoList;
    public static volatile SingularAttribute<Localidad, LocalidadPK> localidadPK;
    public static volatile ListAttribute<Localidad, Curso> cursoList;

}