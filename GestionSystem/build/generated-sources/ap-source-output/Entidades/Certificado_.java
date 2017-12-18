package Entidades;

import Entidades.InscripcionFpa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Certificado.class)
public class Certificado_ { 

    public static volatile SingularAttribute<Certificado, String> retiradoPor;
    public static volatile SingularAttribute<Certificado, Date> fechaRecibido;
    public static volatile SingularAttribute<Certificado, String> entregado;
    public static volatile SingularAttribute<Certificado, Integer> id;
    public static volatile SingularAttribute<Certificado, Date> fechaEntregado;
    public static volatile SingularAttribute<Certificado, InscripcionFpa> inscripcionFpa;

}