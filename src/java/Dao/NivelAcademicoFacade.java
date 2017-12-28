/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.NivelAcademico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }
    
    public boolean NivelAcademicoUnico(NivelAcademico nivelAcademico) {
        boolean b;
        TypedQuery<NivelAcademico> q = this.em.createQuery("SELECT f FROM NivelAcademico f WHERE f.descripcion = :n", NivelAcademico.class);
        q.setParameter("n", nivelAcademico.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public NivelAcademico findByNivelAcademico(String nivelAcademico) {
        TypedQuery<NivelAcademico> q = this.em.createQuery("SELECT f FROM NivelAcademico f WHERE f.descripcion = :n", NivelAcademico.class);
        q.setParameter("n", nivelAcademico);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }

}
