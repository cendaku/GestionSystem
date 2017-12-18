package Entidades;

import Entidades.Alumno;
import Entidades.Estado;
import Entidades.Instructor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(NivelAcademico.class)
public class NivelAcademico_ { 

    public static volatile SingularAttribute<NivelAcademico, String> descripcion;
    public static volatile SingularAttribute<NivelAcademico, Estado> estado;
    public static volatile ListAttribute<NivelAcademico, Instructor> instructorList;
    public static volatile ListAttribute<NivelAcademico, Alumno> alumnoList;
    public static volatile SingularAttribute<NivelAcademico, Integer> id;

}