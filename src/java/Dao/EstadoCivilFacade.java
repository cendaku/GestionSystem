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
    
}
