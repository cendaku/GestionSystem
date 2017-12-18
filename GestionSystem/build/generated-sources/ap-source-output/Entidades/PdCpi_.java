package Entidades;

import Entidades.Horario;
import Entidades.InscripcionCpi;
import Entidades.PdCpiPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(PdCpi.class)
public class PdCpi_ { 

    public static volatile SingularAttribute<PdCpi, PdCpiPK> pdCpiPK;
    public static volatile SingularAttribute<PdCpi, String> coordinadorIts;
    public static volatile SingularAttribute<PdCpi, String> frecuencia;
    public static volatile SingularAttribute<PdCpi, String> municipio;
    public static volatile ListAttribute<PdCpi, InscripcionCpi> inscripcionCpiList;
    public static volatile SingularAttribute<PdCpi, String> unidadOperativa;
    public static volatile SingularAttribute<PdCpi, String> programa;
    public static volatile SingularAttribute<PdCpi, String> inicio;
    public static volatile SingularAttribute<PdCpi, String> clausura;
    public static volatile SingularAttribute<PdCpi, String> especialidad;
    public static volatile SingularAttribute<PdCpi, String> horasTotales;
    public static volatile SingularAttribute<PdCpi, String> areaDesarrollo;
    public static volatile SingularAttribute<PdCpi, Integer> activo;
    public static volatile ListAttribute<PdCpi, Horario> horarioList;

}