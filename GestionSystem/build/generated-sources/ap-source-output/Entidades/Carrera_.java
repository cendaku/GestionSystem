package Entidades;

import Entidades.CarreraHabilitada;
import Entidades.InscripcionCpi;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Carrera.class)
public class Carrera_ { 

    public static volatile SingularAttribute<Carrera, String> descripcion;
    public static volatile ListAttribute<Carrera, InscripcionCpi> inscripcionCpiList;
    public static volatile SingularAttribute<Carrera, Boolean> activoCpi;
    public static volatile ListAttribute<Carrera, CarreraHabilitada> carreraHabilitadaList;
    public static volatile SingularAttribute<Carrera, Integer> id;
    public static volatile ListAttribute<Carrera, InscripcionCpi> inscripcionCpiList1;

}