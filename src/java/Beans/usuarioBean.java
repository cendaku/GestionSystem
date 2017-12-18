package Beans;

import Dao.RolFacade;
import Dao.UsuarioFacade;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named(value = "usuarioBean")
@RequestScoped
public class usuarioBean {

    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    private Integer Rolid;   
    private String contraActual;
    private String contra1;
    private String contra2;

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    private UsuarioFacade usuarioEJB;

    public usuarioBean() {
        this.selectedUsuario = new Usuario();
        this.usuarios = new ArrayList<>();

    }

    public String getContraActual() {
        return contraActual;
    }

    public void setContraActual(String contraActual) {
        this.contraActual = contraActual;
    }

    public String getContra1() {
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }
    
    public List<Usuario> getUsuarios() {
        this.usuarios = usuarioFacade.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getRolid() {
        return Rolid;
    }

    public void setRolid(Integer Rolid) {
        this.Rolid = Rolid;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void EliminarUsuario(ActionEvent actionEvent) {
        Usuario us = usuarioFacade.find(selectedUsuario.getCi());
        usuarioFacade.remove(us);
    }
    
    public void ModificarUsuario(ActionEvent actionEvent) {
        //usuarioFacade.edit(selectedUsuario);
        
        Usuario usuario = usuarioFacade.find(selectedUsuario.getCi()); 
        String ms;
        if (usuario.getRol().getId()> 1) {
            usuario.setNombre(selectedUsuario.getNombre());
            usuario.setApellido(selectedUsuario.getApellido());
            usuario.setActivo(selectedUsuario.getActivo());
            usuario.setRol(selectedUsuario.getRol());
            usuarioFacade.edit(selectedUsuario); 
            ms = "Se modifico correctamente el Usuario";
        } else {
            ms = "¡¡El Usuario Administrador no se puede modificar!!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void CrearUsuario(ActionEvent actionEvent) {
        String ms;
        if (usuarioFacade.Cifijo(selectedUsuario)) {
            Usuario usuario = new Usuario(); 
            usuario.setCi(selectedUsuario.getCi());
            usuarioFacade.create(selectedUsuario); 
            ms = "Se creo correctamente el Usuario";
        }else{
            ms = "Error al creal el Usuario, el Usuario ya existe!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", ms);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    /*public void btnCambiarClave(ActionEvent actionEvent){
        FacesMessage msg;
        this.selectedUsuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLog");
        this.selectedUsuario.setPassword(this.contraActual);
        this.selectedUsuario=usuarioFacade.login(this.selectedUsuario);
        
        if (this.selectedUsuario != null){
            if(!this.contra1.equals(this.contra2)){
                msg=new FacesMessage(FacesMessage.SEVERITY_WARN,"Atencion","La Clave no coinciden!!");
            }else{
                String textoEncriptadoConMD5=DigestUtils.md5Hex(this.contra1);
                this.selectedUsuario.setPassword(textoEncriptadoConMD5);
                
                if (usuarioFacade.Cifijo(selectedUsuario)){
                    msg=new FacesMessage(FacesMessage.SEVERITY_WARN,"Listo","Contraseña Cambiada Exitosamente!!");
                    this.contraActual="";
                    this.contra1="";
                    this.contra2="";
                }else{
                    msg=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error 1","Error al cambiar la contraseña!!");
                }
            }
        }else{
            msg=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error 2","Error al cambiar la contraseña!!");
            if(this.selectedUsuario == null){
                this.selectedUsuario = new Usuario();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/

}
