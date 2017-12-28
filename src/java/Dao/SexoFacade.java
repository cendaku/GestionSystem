package Dao;

import Entidades.Sexo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class SexoFacade extends AbstractFacade<Sexo> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SexoFacade() {
        super(Sexo.class);
    }

    public boolean SexoUnico(Sexo sexo) {
        boolean b;
        TypedQuery<Sexo> q = this.em.createQuery("SELECT f FROM Sexo f WHERE f.descripcion = :n", Sexo.class);
        q.setParameter("n", sexo.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Sexo findBySexo(String sexo) {
        TypedQuery<Sexo> q = this.em.createQuery("SELECT f FROM Sexo f WHERE f.descripcion = :n", Sexo.class);
        q.setParameter("n", sexo);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }

}
