/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Salario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class SalarioFacade extends AbstractFacade<Salario> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalarioFacade() {
        super(Salario.class);
    }
    
    public boolean SalarioUnico(Salario salario) {
        boolean b;
        TypedQuery<Salario> q = this.em.createQuery("SELECT f FROM Salario f WHERE f.descripcion = :n", Salario.class);
        q.setParameter("n", salario.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Salario findBySalario(String salario) {
        TypedQuery<Salario> q = this.em.createQuery("SELECT f FROM Salario f WHERE f.descripcion = :n", Salario.class);
        q.setParameter("n", salario);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
