/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Zona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class ZonaFacade extends AbstractFacade<Zona> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaFacade() {
        super(Zona.class);
    }
    
    public boolean ZonaUnico(Zona zona) {
        boolean b;
        TypedQuery<Zona> q = this.em.createQuery("SELECT f FROM Zona f WHERE f.descripcion = :n", Zona.class);
        q.setParameter("n", zona.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Zona findByZona(String zona) {
        TypedQuery<Zona> q = this.em.createQuery("SELECT f FROM Zona f WHERE f.descripcion = :n", Zona.class);
        q.setParameter("n", zona);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
