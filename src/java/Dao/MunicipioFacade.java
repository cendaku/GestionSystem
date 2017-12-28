/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Municipio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class MunicipioFacade extends AbstractFacade<Municipio> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }
    
    public boolean MunicipioUnico(Municipio municipio) {
        boolean b;
        TypedQuery<Municipio> q = this.em.createQuery("SELECT f FROM Municipio f WHERE f.descripcion = :n", Municipio.class);
        q.setParameter("n", municipio.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Municipio findByMunicipio(String municipio) {
        TypedQuery<Municipio> q = this.em.createQuery("SELECT f FROM Municipio f WHERE f.descripcion = :n", Municipio.class);
        q.setParameter("n", municipio);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
