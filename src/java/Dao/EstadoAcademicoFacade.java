/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.EstadoAcademico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class EstadoAcademicoFacade extends AbstractFacade<EstadoAcademico> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoAcademicoFacade() {
        super(EstadoAcademico.class);
    }
    
    public List<EstadoAcademico> findByNivelAcademico(Integer nivelAcademico) {
        TypedQuery<EstadoAcademico> q = em.createQuery("SELECT p FROM EstadoAcademico p WHERE p.nivelAcademico.id = :m", EstadoAcademico.class);
        q.setParameter("m", nivelAcademico);
        return (q.getResultList());

    }

    public boolean EstadoAcademicoUnico(EstadoAcademico estadoAcademico) {
        boolean b;
        TypedQuery<EstadoAcademico> q = this.em.createQuery("SELECT f FROM EstadoAcademico f WHERE f.descripcion = :n", EstadoAcademico.class);
        q.setParameter("n", estadoAcademico.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public EstadoAcademico findByEstadoAcademico(String estadoAcademico) {
        TypedQuery<EstadoAcademico> q = this.em.createQuery("SELECT f FROM EstadoAcademico f WHERE f.descripcion = :n", EstadoAcademico.class);
        q.setParameter("n", estadoAcademico);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
