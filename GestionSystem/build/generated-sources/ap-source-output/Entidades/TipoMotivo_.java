package Entidades;

import Entidades.Documento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(TipoMotivo.class)
public class TipoMotivo_ { 

    public static volatile SingularAttribute<TipoMotivo, String> descripcion;
    public static volatile ListAttribute<TipoMotivo, Documento> documentoList;
    public static volatile SingularAttribute<TipoMotivo, Integer> id;

}