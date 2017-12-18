package Entidades;

import Entidades.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(FrecuenciaDiaria.class)
public class FrecuenciaDiaria_ { 

    public static volatile SingularAttribute<FrecuenciaDiaria, String> descripcion;
    public static volatile SingularAttribute<FrecuenciaDiaria, Integer> id;
    public static volatile ListAttribute<FrecuenciaDiaria, Curso> cursoList;

}