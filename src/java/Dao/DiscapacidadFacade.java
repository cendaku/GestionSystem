/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Discapacidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class DiscapacidadFacade extends AbstractFacade<Discapacidad> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscapacidadFacade() {
        super(Discapacidad.class);
    }

    public boolean DiscapacidadUnico(Discapacidad discapacidad) {
        boolean b;
        TypedQuery<Discapacidad> q = this.em.createQuery("SELECT f FROM Discapacidad f WHERE f.descripcion = :n", Discapacidad.class);
        q.setParameter("n", discapacidad.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Discapacidad findByDiscapacidad(String discapacidad) {
        TypedQuery<Discapacidad> q = this.em.createQuery("SELECT f FROM Discapacidad f WHERE f.descripcion = :n", Discapacidad.class);
        q.setParameter("n", discapacidad);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
