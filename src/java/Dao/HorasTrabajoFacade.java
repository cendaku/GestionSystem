/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.HorasTrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class HorasTrabajoFacade extends AbstractFacade<HorasTrabajo> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorasTrabajoFacade() {
        super(HorasTrabajo.class);
    }
    
    public boolean HorasTrabajoUnico(HorasTrabajo horasTrabajo) {
        boolean b;
        TypedQuery<HorasTrabajo> q = this.em.createQuery("SELECT f FROM HorasTrabajo f WHERE f.descripcion = :n", HorasTrabajo.class);
        q.setParameter("n", horasTrabajo.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public HorasTrabajo findByHorasTrabajo(String horasTrabajo) {
        TypedQuery<HorasTrabajo> q = this.em.createQuery("SELECT f FROM HorasTrabajo f WHERE f.descripcion = :n", HorasTrabajo.class);
        q.setParameter("n", horasTrabajo);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
