package Entidades;

import Entidades.Alumno;
import Entidades.Documento;
import Entidades.Instructor;
import Entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Documento> documentoList;
    public static volatile ListAttribute<Usuario, Instructor> instructorList;
    public static volatile SingularAttribute<Usuario, Integer> ci;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile ListAttribute<Usuario, Alumno> alumnoList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, Integer> activo;

}