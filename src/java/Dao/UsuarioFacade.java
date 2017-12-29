/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario us) {
        Usuario usuario = null;
        String consultar;
        try {
            consultar = "FROM Usuario u WHERE u.ci = ?1 and u.password = ?2";
            Query query = em.createQuery(consultar);
            query.setParameter(1, us.getCi());
            query.setParameter(2, us.getPassword());

            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        /*finally{
            //em.close();
        }*/
        return usuario;
    }

    public Usuario findByCi(Usuario usuario) {
        TypedQuery<Usuario> q = this.em.createQuery("SELECT f FROM Usuario f WHERE f.ci = :n", Usuario.class);
        q.setParameter("n", usuario.getCi());
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public boolean Cifijo(Usuario usuario) {
        boolean b;
        TypedQuery<Usuario> q = this.em.createQuery("SELECT f FROM Usuario f WHERE f.ci = :n", Usuario.class);
        q.setParameter("n", usuario.getCi());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }
}
