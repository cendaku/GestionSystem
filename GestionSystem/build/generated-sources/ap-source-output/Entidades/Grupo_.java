package Entidades;

import Entidades.CarreraHabilitada;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Grupo.class)
public class Grupo_ { 

    public static volatile SingularAttribute<Grupo, String> malla;
    public static volatile SingularAttribute<Grupo, String> resolucion;
    public static volatile SingularAttribute<Grupo, String> anhoInicial;
    public static volatile ListAttribute<Grupo, CarreraHabilitada> carreraHabilitadaList;
    public static volatile SingularAttribute<Grupo, Integer> id;
    public static volatile SingularAttribute<Grupo, String> anhoFinal;
    public static volatile SingularAttribute<Grupo, Integer> activo;

}