/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Rol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
    public boolean RolUnico(Rol rol) {
        boolean b;
        TypedQuery<Rol> q = this.em.createQuery("SELECT f FROM Rol f WHERE f.descripcion = :n", Rol.class);
        q.setParameter("n", rol.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Rol findByRol(String rol) {
        TypedQuery<Rol> q = this.em.createQuery("SELECT f FROM Rol f WHERE f.descripcion = :n", Rol.class);
        q.setParameter("n", rol);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
