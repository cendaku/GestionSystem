/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Nacionalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }
    
    public boolean NacionalidadUnico(Nacionalidad nacionalidad) {
        boolean b;
        TypedQuery<Nacionalidad> q = this.em.createQuery("SELECT f FROM Nacionalidad f WHERE f.descripcion = :n", Nacionalidad.class);
        q.setParameter("n", nacionalidad.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Nacionalidad findByNacionalidad(String nacionalidad) {
        TypedQuery<Nacionalidad> q = this.em.createQuery("SELECT f FROM Nacionalidad f WHERE f.descripcion = :n", Nacionalidad.class);
        q.setParameter("n", nacionalidad);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
