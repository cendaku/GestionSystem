package Entidades;

import Entidades.ContratoInstructorits;
import Entidades.InscripcionIts;
import Entidades.TrabajoPracticoitsPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(TrabajoPracticoits.class)
public class TrabajoPracticoits_ { 

    public static volatile SingularAttribute<TrabajoPracticoits, TrabajoPracticoitsPK> trabajoPracticoitsPK;
    public static volatile SingularAttribute<TrabajoPracticoits, String> ruta;
    public static volatile SingularAttribute<TrabajoPracticoits, Integer> puntajetotal;
    public static volatile SingularAttribute<TrabajoPracticoits, ContratoInstructorits> contratoInstructorits;
    public static volatile SingularAttribute<TrabajoPracticoits, String> nombre;
    public static volatile SingularAttribute<TrabajoPracticoits, InscripcionIts> inscripcionIts;

}