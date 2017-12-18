/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.UsuarioFacade;
import Entidades.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author administrador
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {
    
    @EJB
    private UsuarioFacade EJBUsuario;
    private Usuario usuario;
    private Usuario ulog;
    
    /*@EJB
    UsuarioFacade usuarioFacade;

    public loginBean() {
        this.usuarioFacade = new UsuarioFacade();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }*/
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUlog() {
        return ulog;
    }

    public void setUlog(Usuario ulog) {
        this.ulog = ulog;
    }
    
    
    public String iniciarSesion(){
        Usuario us;
        String redireccion = null;
        try{
            us = EJBUsuario.iniciarSesion(usuario);
            if(us!=null){
                //Almacenar en la sessión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                ulog=us;
                redireccion = "/vista/index?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credencial Incorrecta"));
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }
    
    public void cerrarSesion(){
        ulog=null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    

    public void verificarSesion() {
        try {  
            FacesContext Context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) Context.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                Context.getExternalContext().redirect("../vista/index.xhtml");
            }
        } catch (IOException e) {
            //log para guardar algum registro de un error 
        }
    }
    public void verificaruser() {
        try {  
            FacesContext Context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) Context.getExternalContext().getSessionMap().get("usuario");
            if(ulog.getRol().getId()> 2){
                Context.getExternalContext().redirect("../vista/index.xhtml");
            }
        } catch (IOException e) {
            //log para guardar algum registro de un error 
        }
    }

}
