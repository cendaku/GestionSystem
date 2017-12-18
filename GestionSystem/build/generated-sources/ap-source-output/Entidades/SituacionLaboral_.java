package Entidades;

import Entidades.Alumno;
import Entidades.HorasTrabajo;
import Entidades.Salario;
import Entidades.TipoTrabajo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(SituacionLaboral.class)
public class SituacionLaboral_ { 

    public static volatile SingularAttribute<SituacionLaboral, Integer> estado;
    public static volatile SingularAttribute<SituacionLaboral, Integer> experiencia;
    public static volatile SingularAttribute<SituacionLaboral, Salario> salario;
    public static volatile ListAttribute<SituacionLaboral, Alumno> alumnoList;
    public static volatile SingularAttribute<SituacionLaboral, Integer> id;
    public static volatile SingularAttribute<SituacionLaboral, Integer> deseo;
    public static volatile SingularAttribute<SituacionLaboral, HorasTrabajo> horasTrabajo;
    public static volatile SingularAttribute<SituacionLaboral, TipoTrabajo> tipoTrabajo;

}