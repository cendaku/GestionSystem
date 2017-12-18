package Entidades;

import Entidades.ContratoInstructoritsPK;
import Entidades.HorarioInstructorits;
import Entidades.Instructor;
import Entidades.MateriaIts;
import Entidades.Notasits;
import Entidades.TrabajoPracticoits;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(ContratoInstructorits.class)
public class ContratoInstructorits_ { 

    public static volatile ListAttribute<ContratoInstructorits, HorarioInstructorits> horarioInstructoritsList;
    public static volatile SingularAttribute<ContratoInstructorits, String> pd;
    public static volatile SingularAttribute<ContratoInstructorits, MateriaIts> materiaIts1;
    public static volatile ListAttribute<ContratoInstructorits, Notasits> notasitsList;
    public static volatile ListAttribute<ContratoInstructorits, TrabajoPracticoits> trabajoPracticoitsList;
    public static volatile SingularAttribute<ContratoInstructorits, ContratoInstructoritsPK> contratoInstructoritsPK;
    public static volatile SingularAttribute<ContratoInstructorits, Instructor> instructor1;

}