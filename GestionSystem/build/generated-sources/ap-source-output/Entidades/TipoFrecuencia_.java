package Entidades;

import Entidades.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(TipoFrecuencia.class)
public class TipoFrecuencia_ { 

    public static volatile SingularAttribute<TipoFrecuencia, String> descripcion;
    public static volatile SingularAttribute<TipoFrecuencia, Integer> id;
    public static volatile ListAttribute<TipoFrecuencia, Curso> cursoList;

}