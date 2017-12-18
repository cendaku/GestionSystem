package Entidades;

import Entidades.Documento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Solicitante.class)
public class Solicitante_ { 

    public static volatile ListAttribute<Solicitante, Documento> documentoList;
    public static volatile SingularAttribute<Solicitante, String> nombreInstitucion;
    public static volatile SingularAttribute<Solicitante, Integer> id;
    public static volatile SingularAttribute<Solicitante, String> telefonoContacto;
    public static volatile SingularAttribute<Solicitante, String> nombreRecepcion;

}