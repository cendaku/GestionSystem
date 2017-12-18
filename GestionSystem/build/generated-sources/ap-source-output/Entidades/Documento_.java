package Entidades;

import Entidades.Solicitante;
import Entidades.TipoDocumento;
import Entidades.TipoMotivo;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T09:49:00")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<Documento, Integer> revisionDireccion;
    public static volatile SingularAttribute<Documento, Solicitante> solicitantes;
    public static volatile SingularAttribute<Documento, Date> fechaRecibido;
    public static volatile SingularAttribute<Documento, String> ruta;
    public static volatile ListAttribute<Documento, TipoMotivo> tipoMotivoList;
    public static volatile SingularAttribute<Documento, Date> fechaEnviado;
    public static volatile SingularAttribute<Documento, Integer> claseDocumento;
    public static volatile SingularAttribute<Documento, Usuario> usuario;
    public static volatile SingularAttribute<Documento, Integer> id;
    public static volatile SingularAttribute<Documento, Integer> estadoSolicitud;
    public static volatile SingularAttribute<Documento, String> observacionDireccion;

}