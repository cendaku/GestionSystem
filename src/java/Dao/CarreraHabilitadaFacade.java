/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.CarreraHabilitada;
import Entidades.Grupo;
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
public class CarreraHabilitadaFacade extends AbstractFacade<CarreraHabilitada> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraHabilitadaFacade() {
        super(CarreraHabilitada.class);
    }
    
    public List<CarreraHabilitada> findByGrupo(Grupo grupo) {
        TypedQuery<CarreraHabilitada> query = em.createQuery("SELECT c FROM CarreraHabilitada c WHERE c.carreraHabilitadaPK.grupo = :grupo", CarreraHabilitada.class);
        query.setParameter("grupo", grupo.getId());
        return query.getResultList();

    }
    
}
