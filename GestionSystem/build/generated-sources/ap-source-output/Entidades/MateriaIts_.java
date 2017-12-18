package Entidades;

import Entidades.CargaHorariaits;
import Entidades.ContratoInstructorits;
import Entidades.SemestreHabilitado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(MateriaIts.class)
public class MateriaIts_ { 

    public static volatile SingularAttribute<MateriaIts, SemestreHabilitado> semestreHabilitado;
    public static volatile SingularAttribute<MateriaIts, CargaHorariaits> cargahoraria;
    public static volatile SingularAttribute<MateriaIts, Integer> id;
    public static volatile SingularAttribute<MateriaIts, String> nombre;
    public static volatile ListAttribute<MateriaIts, ContratoInstructorits> contratoInstructoritsList;

}