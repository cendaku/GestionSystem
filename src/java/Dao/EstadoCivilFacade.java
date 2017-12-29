/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.EstadoCivil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }
    
    public boolean EstadoCivilUnico(EstadoCivil estadoCivil) {
        boolean b;
        TypedQuery<EstadoCivil> q = this.em.createQuery("SELECT f FROM EstadoCivil f WHERE f.descripcion = :n", EstadoCivil.class);
        q.setParameter("n", estadoCivil.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public EstadoCivil findByEstadoCivil(String estadoCivil) {
        TypedQuery<EstadoCivil> q = this.em.createQuery("SELECT f FROM EstadoCivil f WHERE f.descripcion = :n", EstadoCivil.class);
        q.setParameter("n", estadoCivil);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
